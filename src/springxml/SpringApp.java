package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Card;

public class SpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Card card = context.getBean("myCard", Card.class);

        System.out.println(card.objectChange());
        System.out.println(card.getApi_id());
        System.out.println(card.getAssignedDeck().getDeck_name());
        System.out.println(card.getCard_id());

        context.close();
    }
}
