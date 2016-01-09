<?php
function getDirContents($dir, &$results = array()){
    $files =array_diff(scandir($dir), array('..', '.','.git'));
    $baseurl = 'http://sandbox.dev:8080';

    foreach($files as $key => $value){
        $path = realpath($dir.DIRECTORY_SEPARATOR.$value);
        if(!is_dir($path)) {
            $results[] = $path;
        } else if($value != "." && $value != "..") {
           getDirContents($path, $results[]); 
            $results[] = $path;
        }
    }
	foreach ($results as $value) {
		$isArray = is_array($value);
		if (!$isArray) {
			$isDir = is_dir($value);
			if (!$isDir) {
				$url = explode("/sf_sandbox", $value);
				echo "<a href='$baseurl$url[1]' target='_blank'>$url[1]</a> <br/>";
			}

		}
	}
}

var_dump(getDirContents(getcwd()));
?>