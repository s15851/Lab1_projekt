<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <header class="site-header">
        <div class="vertical">
            <h1 class="page-title"><a href="/">Calculation</a></h1>
        </div>
    </header>
	<form action="Calculation" method="post">
		<div>
			<label>Capital: 
				<input type="number" id="capital" name="capital" min="0" value="100000" required value="0"/> 
			</label>
		</div>
		<div>
			<label>Number of Installments: 
				<input type="number" id="installments" name="installments" min="0" max="480" value="120" required value="0"/> 
			</label>
		</div>
		<div>
			<label>Rate: 
				<input type="number" id="rate" name="rate" min="0" max="100" step="0.1" value="2.5" required value="0"/> 
			</label>
		</div>
		<div>
			<label>Credit Fee: 
				<input type="number" id="fee" name="fee" min="0" value="2000" required value="0"/> 
			</label>
		</div>		
		<div>
            <label>Credit Type</label>
            <label><input type="radio" id='type' name="type" value="EQUAL" checked="checked"> Equals</label>
            <label><input type="radio" id='type' name="type" value="DECREASING"> Decreasing</label>
        </div>
		<button class="button" type="submit">Calculate</button>
	</form>
</body>
</html>