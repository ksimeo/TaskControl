/**
 * Created by VLAD on 13.06.2014.
 */

$(document).ready(
    function () {
        $("#tasktitle").click(clickAction())
    });

function clickAction()
{
    $("#tasktitle").click(
        function()
        {
            var title = $("#tasktitle").val();
            console.log(title)

            $.post("/description",("title=" + title),
            function(responsetext)
            {
                $("#ansver").text(responsetext)
            });
        });



};