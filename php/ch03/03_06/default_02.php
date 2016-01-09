<?php
$unit_cost = 1;

// If unit cost is set and not implicitly false 
if (isset($unit_cost) && $unit_cost) {
	$wholesale_price = $unit_cost;
} else {
	$wholesale_price = 25;
}

echo $wholesale_price;
