import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "PetNameSearch", urlPatterns = "/deckNameSearch")
public class SearchServlet extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/KookyDB";
    private final String USERNAME = "tyler";
    private final String PASSWORD = "tyler";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            String searchTerm = request.getParameter("deckName");
            System.out.println(searchTerm);
            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath(DATABASE_PATH);

            StringBuilder sql = new StringBuilder("SELECT deck.deck_name, cards.card_id, deck_cards.num_of_cards");
            sql.append(" FROM deck, deck_cards, cards");
            sql.append(" WHERE deck_cards.deck_id = deck.deck_id");
            sql.append(" AND deck_cards.card_id = cards.card_id");
            sql.append(" AND deck.deck_name = ?");
            sql.append(" ORDER BY deck.deck_name"); // Don't end SQL with semicolon!
//            String sql = "SELECT deck.deck_id FROM deck WHERE deck.deck_name = ?";
            // Create a connection
            conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);

            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, searchTerm);

            rset = pstmt.executeQuery();

            // Create a StringBuilder for ease of appending strings
            StringBuilder output = new StringBuilder();

            // HTML to create a simple web page
            output.append("<html><body><ul>");
            String oldDeckName = null;
            // Loop while the result set has more rows
            while (rset.next()) {
                //int deckId = rset.getInt("deck_id");
              //  output.append("<li>").append(deckId).append("</li>");
                // Get the first string (the pet name) from each record
                String deckName = rset.getString(1);
                int cardId = rset.getInt(2);
                int numOfCards = rset.getInt(3);
                // Append it as a list item
                if(deckName != oldDeckName)
                {
                    if(oldDeckName != null)
                    {
                        output.append("</li>");
                    }
                    output.append("<li>" + deckName + "'s cards:<br>This card has Id: " + cardId + " appears " + numOfCards + ((numOfCards == 1) ? " time in this deck." : " times in this deck.<br>"));
                }
                else
                {
                    output.append("This card has Id: " + cardId + " appears " + numOfCards + ((numOfCards == 1) ? " time in this deck." : " times in this deck.<br>"));
                }

                oldDeckName = deckName;
            }
            // Close all those opening tags
            output.append("</li></ul></body></html>");

            // Send the HTML as the response
            response.getWriter().print(output.toString());

        } catch (SQLException | ClassNotFoundException e) {
            // If there's an exception locating the driver, send IT as the response
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}