<?php

// $xmas2016 = strtotime('Dec 25, 2016');
// echo date('l, F j, Y', $xmas2016);


$date1 = new DateTime();
$date2 = new DateTime();


$westCoast = new DateTimeZone('America/Los_Angeles');

$date2->setTimezone($westCoast);

echo $date1->format('g:ia, l, F j, Y') . '<br/>';

echo $date2->format('g:ia, l, F j, Y') . '<br/>';
