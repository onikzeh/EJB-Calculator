<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>Salary Calculator</title>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script>
        $(document).on("click", "#call", function() {
            var params = {
                value1: "1",
                value2: "2"
            };

            $.post("${pageContext.request.contextPath}/calculate", $.param(params), function(response) {
                $("#result").text(response);
            });
        });
    </script>
  </head>

  <body>
    <button id="call">Calculate</button>
      <br><br>
      Calculation Result:<div id="result"></div>
  </body>
</html>