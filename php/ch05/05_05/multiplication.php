<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Challenge: using loops</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Multiplication Table</h1>
<table>
	<?php
		//Create first row of table headers
		echo "<tr>"; 
		echo "<th>&nbsp;</th>";
		for ($k = 1; $k < 13; $k++) :
			echo "<th>$k</th>";
		endfor;
		echo "</tr>";
		
		//create remaining rows and col
		for ($i = 1; $i < 13; $i++) {
			echo "<tr>";
			echo "<th>$i</th>";
			for ($j = 1; $j < 13; $j++) {
				$val = $j * $i;
				echo "<td>$val</td>";
			}
			echo "</tr>";
		}
	?>
</table>
</body>
</html>