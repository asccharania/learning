<?php

function cpyrightDate($startYear) {
	$thisYear = date('Y');
	if ($startYear < $thisYear) {
		return "&copy; $startYear&ndash;$thisYear";	
	} else {
		return "&copy; $startYear";
	}
}

echo cpyrightDate(1904);