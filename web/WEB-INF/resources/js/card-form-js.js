$(document).ready(function(){
$("#cardForm").on("submit", function () {
    var allTypes = '';
    $(".cardType").each(function(i, types){
        allTypes += types[i].val();
    });
    $("#allCardTypes").val(allTypes);
})
});