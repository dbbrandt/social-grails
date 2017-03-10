<IMG src="http://inbound.linktrust.com/redirconsume.aspx?CID=27737&p=img" width="1" height="1" border="0">
<a href="http://www.precidix.com/test/leadCartConfirm.php?CID=27702">Record Arb Offer LeadTrack Confirmation</a>

<?php

include("dbinit.php");
include("systemEventLog.php");

echo "<br><b><center>Datapass Output</center></b><br><br>";

echo "<hr><h2>Request Headers:</H2>";

if (!function_exists('getallheaders'))
{
    function getallheaders()
    {
       foreach ($_SERVER as $name => $value)
       {
           if (substr($name, 0, 5) == 'HTTP_')
           {
               $headers[str_replace(' ', '-', ucwords(strtolower(str_replace('_', ' ', substr($name, 5)))))] = $value;
           }
       }
       return $headers;
    }
}

$event_description = " showinput.php: ";

$headers = getallheaders();
for(reset($headers); $key = key($headers); next($headers)) {
	$event_description .= "headers[$key] = ".$headers[$key]."<br>\n";
}

$event_description .= "<br><u>GET parameters</u><br><br>\n";
foreach ($_GET as $name => $value)  {
    $event_description .= $name . " => " . $value . "<br>\n";
}

$event_description .=  "<br><u>POST parameters</u><br><br>\n";
foreach ($_POST as $name => $value)  {
    $event_description .= $name . " => " . $value . "<br>\n";
}

$event_description .=  "<br><u>Cookies</u><br><br>\n";
foreach ($_COOKIE as $name => $value)  {
    $event_description .= $name . " => " . $value . "<br>\n";
}

if ( $_SERVER['REQUEST_METHOD'] === 'POST' )
    {
    		
   		$event_description .= " Post Method Detected\n";
   		
        // Read the input from stdin
        $postText = trim(file_get_contents('php://input'));
		$event_description .= " trim(file_get_contents('php://input'): length=" . strlen($postText) . "value: $postText<br>\n";
   		
		$postText = $GLOBALS['HTTP_RAW_POST_DATA'];        
		$event_description .= " GLOBALS['HTTP_RAW_POST_DATA']: length=" . strlen($postText) . "value: $postText<br>\n";
    }
$event_description .= "<br>Multi Part Post Data</u><br><br>\n"; 
$event_description .= "Stringlength = " . strlen($postText) . " value: " . $postText . "<br>\n";

$event_description .= "<br><u>SESSION parameters</u><br><br>\n";
foreach ($_SESSION as $name => $value)  {
    $event_description .= $name . " => " . $value . "<br>\n";
}

echo $event_description;

log_event(4, 999999, $event_description,'');


?>
