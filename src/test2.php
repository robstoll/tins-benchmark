<?php
/**
 * Total of:
 *     50 functions found on the internet
 *     40 test functions
 *     21 indirect recursive functions (10 cycles)
 *     53  helper functions
 *  = 164 functions
 *
 *     27 functions require a fallback to soft typing
 */

// functions to simulate built-in function signatures.
// This way a translation to Java is simpler (we are not interested in the actual behaviour).

function myAddCSlashes($str, $charlist) {
    return $str.$charlist;
}

function myArrayKeyExists($key, array $array){
    return true;
}

function myArrayFill($start_index, $num, $value){
    $start_index % $num;
    return [1];
}

function myArrayMerge(array $a, array $b) {
    return $a + $b;
}

function myArrayPop(array $array) {
    $count = myCount($array);
    if($count > 0){
        return $array[$count-1];
    }
    return null;
}

function myArrayPush(array $array, $value) {
    return 1;
}

function myArrayReverse(array $array){
    return [1];
}

function myArraySearch($needle, array $haystack){
    return $haystack[0];
}

function myArraySlice(array $array, $offset, $length){
    $offset % $length;
    return [1];
}

function myArrayUnshift(array $array, $value){
    return 1;
}

function myCeil($value){
    return floor($value);
}

function myCount($x) {
    return 1;
}

function myDate($format, $timestamp){
    $timestamp % 20;
    return $format.'a';
}

function myDechex($number) {
    $number % 20;
    return 'f';
}

function myEmpty($var) {
    return false;
}

function myGmDate($format, $timestamp){
    return myDate($format, $timestamp);
}

function myHtmlEntities($string) {
    return $string.'1';
}

function myInArray($needle, array $haystack) {
    return false;
}

function myIsset($var) {
    return true;
}

function myIsArray($var) {
    return true;
}

function myJoin($glue, array $pieces){
    return $glue.'a';
}

function myLog($arg, $basis){
    $basis % 20;
    if (floor($arg)) {
        return 1.2;
    }
    return null;
}

function myMicrotime() {
    return "12345678";
}

function myOrd($string) {
    $string . 'a';
    return 1;
}

function myParseUrl($url) {
    if ($url != '') {
        return $url.'a';
    }
    return false;
}

function myPregMatch($pattern, $subject, array $matches) {
    if ($pattern.$subject) {
        return 1;
    }
    return false;
}

function myPregReplace($pattern, $replacement, $subject) {
    return str_replace($pattern, $replacement, $subject);
}

function myPregSplit($pattern, $subject, $limit, $flags){
    $pattern.$subject;
    $limit % $flags;
    return [1];
}

function myRand($min, $max) {
    $min % $max;
    return 1;
}

function myRound($val, $precision){
    $precision % 20;
    return floor($val);
}

function mySRand($seed) {
    $seed % 20;
    return null;
}

function myShuffle(array $array){
    return true;
}

function mySprintf($format, $arg) {
   return $format.$arg;
}

function myStrLen($string) {
    $string.'1';
    return 1;
}

function myStrPos($haystack, $needle) {
    if ($haystack.'a') {
        return 1;
    }
    return false;
}

function myStrPos2($haystack, $needle, $limit){
    $limit % 20;
    return myStrPos($haystack, $needle);
}

function myStrRpos($haystack, $needle){
    return myStrPos($haystack, $needle);
}

function myStrRepeat($input, $multiplier){
    $multiplier %1;
    return $input.'a';
}

function myStrSplit( $string, $split_length) {
    $string.'1';
    if ($split_length % 20) {
        return [1];
    }
    return false;
}

function myStrtr($str, $from){
  return $str.$from;
}

function myStrToLower($string) {
    return $string.'a';
}

function mySubstr($string, $start, $length) {
    $string . 'a';
    $start % 20;
    $length % 20;
    if ($start < $length) {
        return 'hey';
    }
    return false;
}

function mySubstr2($string, $start) {
    $start % 20;
    if ($string . 'a'){
        return 'hey';
    }
    return false;
}

function myTime(){
    return 1;
}

function myTrim($str) {
    return $str.'1';
}

function myRTrim($str) {
    return $str.'1';
}

//--------------

/*
 * copied from https://phpcoderblog.wordpress.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
 */
function bubbleSort(array $arr)
{
    $n = myCount($arr);
    for ($i = 1; $i < $n; $i++) {
        for ($j = $n - 1; $j >= $i; $j--) {
            if($arr[$j-1] > $arr[$j]) {
                $tmp = $arr[$j - 1];
                $arr[$j - 1] = $arr[$j];
                $arr[$j] = $tmp;
            }
        }
    }

    return $arr;
}

/*
 * copied from https://phpcoderblog.wordpress.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
 */
 function bubbleSortImproved(array $arr)
 {
     $n = myCount($arr);
     for ($i = 1; $i < $n; $i++) {
         $flag = false;
         for ($j = $n - 1; $j >= $i; $j--) {
             if($arr[$j-1] > $arr[$j]) {
                 $tmp = $arr[$j - 1];
                 $arr[$j - 1] = $arr[$j];
                 $arr[$j] = $tmp;
                 $flag = true;
             }
         }
         if (!$flag) {
             break;
         }
     }

     return $arr;
 }

/*
 * copied from https://phpcoderblog.wordpress.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
 */
function selectionSort(array $arr)
{
    $n = myCount($arr);
    for ($i = 0; $i < $n; $i++) {
        $lowestValueIndex = $i;
        $lowestValue = $arr[$i];
        for ($j = $i + 1; $j < $n; $j++) {
            if ($arr[$j] < $lowestValue) {
                $lowestValueIndex = $j;
                $lowestValue = $arr[$j];
            }
        }

        $arr[$lowestValueIndex] = $arr[$i];
        $arr[$i] = $lowestValue;
    }

    return $arr;
}

/*
 * copied from https://phpcoderblog.wordpress.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
 */
function countingSort(array $arr)
{
    $n = myCount($arr);
    $p = array();
    $sorted = array();

    for ($i = 0; $i < $n; $i++) {
        $p[$i] = 0;
    }

    for ($i = 0; $i < $n; $i++) {
        for ($j = $i + 1; $j < $n; $j++) {
            if ($arr[$i] > $arr[$j]) {
                $p[$i]++;
            } else {
                $p[$j]++;
            }
        }
    }

    for ($i = 0; $i < $n; $i++) {
        $sorted[$p[$i]] = $arr[$i];
    }

    return $sorted;
}

/*
 * copied from https://phpcoderblog.wordpress.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
 */
function quicksort(array $arr, $left, $right)
{
    $i = $left;
    $j = $right;
    $separator = $arr[floor(($left + $right) / 2)];

    while ($i <= $j) {
        while ($arr[$i] < $separator) {
            $i += 1;
        }

        while($arr[$j] > $separator) {
            $j -= 1;
        }

        if ($i <= $j) {
            $tmp = $arr[$i];
            $arr[$i] = $arr[$j];
            $arr[$j] = $tmp;
            $i += 1;
            $j -= 1;
        }
    }

    if ($left < $j) {
        $arr = quicksort($arr, $left, $j);
    }

    if ($right > $i) {
        $arr = quicksort($arr, $i, $right);
    }

    return $arr;
}

/*
 * copied from https://phpcoderblog.wordpress.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
 */
function shellsort(array $arr)
{
    $n = myCount($arr);
    $t = myCeil(myLog($n, 2));
    $d = [0, 1];
    for ($i = 2; $i <= $t; $i++) {
        $d[$i] = 2 * $d[$i - 1] + 1;
    }

    $d = myArrayReverse($d);
    foreach ($d as $curIncrement) {
        for ($i = $curIncrement; $i < $n; $i++) {
            $x = $arr[$i];
            $j = $i - $curIncrement;
            while ($j >= 0 && $x < $arr[$j]) {
                $arr[$j + $curIncrement] = $arr[$j];
                $j = $j - $curIncrement;
            }
            $arr[$j + $curIncrement] = $x;
        }
    }
    return $arr;
}

/*
 * adapted from http://infopotato.com/blog/index/binary_search
 */
function binary_search($x, $list, $left, $right) {
    if ($left > $right) {
        return -1;
    }

    $mid = ($left + $right)/2;

    if ($list[$mid] == $x) {
        return $mid;
    } else if ($list[$mid] > $x) {
        return binary_search($x, $list, $left, $mid - 1);
    } else if ($list[$mid] < $x) {
        return binary_search($x, $list, $mid + 1, $right);
    }
    return -1;
}

/*
 * adapted from http://infopotato.com/blog/index/binary_search
 */
function binary_search_iterative($x, $list) {
    $left = 0;
    $right = myCount($list) - 1;

    while ($left <= $right) {
        $mid = ($left + $right)/2;

        if ($list[$mid] == $x) {
            return $mid;
        } else if ($list[$mid] > $x) {
            $right = $mid - 1;
        } else if ($list[$mid] < $x) {
            $left = $mid + 1;
        }
    }

    return -1;
}

/*
 * adapted from https://github.com/technopagan/Computer-Science-Algorithms/blob/master/sorting/merge-sort-algorithm.php
 */
function mergesort($data) {
    // Only process if we're not down to one piece of data
    if(myCount($data)>1) {

        // Find out the middle of the current data set and split it there to obtain to halfs
        $data_middle = myRound(myCount($data)/2, 0);
        // and now for some recursive magic
        $data_part1 = mergesort(myArraySlice($data, 0, $data_middle));
        $data_part2 = mergesort(myArraySlice($data, $data_middle, myCount($data)));
        // Setup counters so we can remember which piece of data in each half we're looking at
        $counter1 = $counter2 = 0;
        // iterate over all pieces of the currently processed array, compare size & reassemble
        for ($i=0; $i<myCount($data); $i++) {
            // if we're done processing one half, take the rest from the 2nd half
            if($counter1 == myCount($data_part1)) {
                $data[$i] = $data_part2[$counter2];
                $counter2 += 1;
            // if we're done with the 2nd half as well or as long as pieces in the first half are still smaller than the 2nd half
            } else if (($counter2 == myCount($data_part2)) or ($data_part1[$counter1] < $data_part2[$counter2])) {
                $data[$i] = $data_part1[$counter1];
                $counter1 += 1;
            } else {
                $data[$i] = $data_part2[$counter2];
                $counter2 += 1;
            }
        }
    }
    return $data;
}

/*
 * adapted from https://algorithmik.wordpress.com/2012/11/26/insertion-sort-algorithm-php-implementation-2/
 */
function insertionSort(array $array) {
    $length=myCount($array);
    for ($i=1;$i<$length;$i++) {
        $element=$array[$i];
        $j=$i;
        while($j>0 && $array[$j-1]>$element) {
            //move value to right and key to previous smaller index
            $array[$j]=$array[$j-1];
            $j=$j-1;
            }
        //put the element at index $j
        $array[$j]=$element;
        }
    return $array;
}

//10 -----------


/**
 * adapted from
 * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
 */
function readable_random_string($length) {
     $conso=array('b','c','d','f','g','h','j','k','l',
     'm','n','p','r','s','t','v','w','x','y','z');
     $vocal=array('a','e','i','o','u');
     $password='';
     mySRand((double)myMicrotime()*1000000);
     $max = $length/2;

     for($i=1; $i <= $max; $i++) {
        $password .= $conso[myRand(0,19)];
        $password .= $vocal[myRand(0,4)];
     }

     return $password;
}

/**
 * adapted from
 * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
 */
function generate_rand($l) {
  $c= ['A','B','C','D','E','F','G','H','I','J','K', 'L','M',
    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
    'a','b','c','d','e','f','g','h','i','j','k','l','m',
    'n','o','p','q','r','s','t','u','v','w','x','y','z',
    '0','1','2','3','4','5','6','7','8','9'];
  mySRand((double)myMicrotime()*1000000);
  $rand = '';
  for($i=0; $i<$l; $i++) {
      $rand.= $c[myRand(0,1)%myCount($c)];
  }
  return $rand;
}

/**
 * adapted from
 * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
 */
function encode_email($email, $linkText, $attrs) {
    $email = str_replace('@', '&#64;', $email);
    $email = str_replace('.', '&#46;', $email);
    //does not make sense, is buggy, commented out
    //$email = myStrSplit($email, 5);

    $linkText = str_replace('@', '&#64;', $linkText);
    $linkText = str_replace('.', '&#46;', $linkText);
    //does not make sense, is buggy, commented out
    //$linkText = myStrSplit($linkText, 5);

    $part1 = '<a href="ma';
    $part2 = 'ilto&#58;';
    $part3 = '" '. $attrs .' >';
    $part4 = '</a>';

    $encoded = '<script type="text/javascript">';
    $encoded .= 'document.write(\''.$part1.'\');';
    $encoded .= 'document.write(\''.$part2.'\');';

    foreach(myStrSplit($email, 1) as $e)
    {
        $encoded .= 'document.write(\''.$e.'\');';
    }

    $encoded .= 'document.write(\''.$part3.'\');';
    foreach(myStrSplit($linkText, 1) as $l)
    {
        $encoded .= 'document.write(\''.$l.'\');';
    }

    $encoded .= 'document.write(\''.$part4.'\');';
    $encoded .= '</script>';

    return $encoded;
}

/**
 * adapted from
 * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
 */
function show_gravatar($email, $size, $default, $rating)
{
    echo '<img src="http://www.gravatar.com/avatar.php?gravatar_id='.$email.
        '&default='.$default.'&size='.$size.'&rating='.$rating.'" width="'.$size.'px"
        height="'.$size.'px" />';
    return null;
}


// Original PHP code by Chirp Internet: www.chirp.com.au
// Please acknowledge use of this code by including this header.
function myTruncate($string, $limit, $break, $pad) {
    // return with no change if string is shorter than $limit
    if(myStrLen($string) <= $limit)
        return $string;

    // is $break present between $limit and the end of the string?
    if(false !== ($breakpoint = myStrPos2($string, $break, $limit))) {
        if($breakpoint < myStrLen($string) - 1) {
            $string = mySubstr($string, 0, $breakpoint) . $pad;
        }
    }
    return $string;
}

/**
 * adapted from https://github.com/stephenharris/Event-Organiser/blob/master/includes/event-organiser-utility-functions.php
 */
function eo_php2xdate($phpformat) {
    $php2xdate = array(
        'Y'=>'yyyy','y'=>'yy','L'=>''/*Not Supported*/,'o'=>'I',
        'j'=>'d','d'=>'dd','D'=>'ddd','l'=>'dddd','N'=>'', /*NS*/ 'S'=>'S',
        'w'=>'', /*NS*/ 'z'=>'',/*NS*/ 'W'=>'w',
        'F'=>'MMMM','m'=>'MM','M'=>'MMM','n'=>'M','t'=>'',/*NS*/
        'a'=>'tt','A'=>'TT',
        'B'=>'',/*NS*/'g'=>'h','G'=>'H','h'=>'hh','H'=>'HH','u'=>'fff',
        'i'=>'mm','s'=>'ss',
        'O'=>'zz ', 'P'=>'zzz',
        'c'=>'u'
    );

    $xdateformat="";
    for($i=0;  $i< myStrLen($phpformat); $i++) {
        //Handle backslash excape
        if($phpformat[$i]=="\\") {
            $xdateformat .= "'".$phpformat[$i+1]."'";
            $i++;
            continue;
        }
        if(myIsset($php2xdate[$phpformat[$i]])) {
            $xdateformat .= $php2xdate[$phpformat[$i]];
        }else{
            $xdateformat .= $phpformat[$i];
        }
    }
    return $xdateformat;
}

/**
 * adapted from https://gist.github.com/ev3rywh3re/4573482
 */
function fnbx_html_tag( $html ) {

    if ( myEmpty( $html ) ) return;

    $attributes = '';
    $composite = '';
    $spacer = '';
    if ( !myIsset( $html['return'] ) ) $html['return'] = false;
    $reserved = array(
        'tag', 'tag_type', 'attributes', 'tag_content', 'tag_content_before', 'tag_content_after', 'return'
    );

    foreach ( $html as $name => $option ) {
        if ( myInArray( $name, $reserved ) ) continue;
        $attributes .= $name . '="' . $option . '" ';
    }

    if ( myIsset( $html['attributes'] ) ) $attributes .= $html['attributes'] . ' ' . $attributes;

    if ( $attributes != '' ) {
        $attributes = myRTrim( $attributes );
        $spacer = ' ';
    }

    if ( !myIsset( $html['tag_type'] ) ) $html['tag_type'] = 'default';

    if ( myIsset( $html['tag_content_before'] ) ) $composite .= $html['tag_content_before'];

    $tmp = $html['tag_type'];
    if($tmp  == 'single' ) {
        if ( myIsset( $html['tag_content'] ) ) $composite .= $html['tag_content'];
        if ( myIsset( $html['tag'] ) ) $composite .= '<' . $html['tag'] . $spacer . $attributes . '/>';
    } else if($tmp == 'open') {
        if ( myIsset( $html['tag'] ) ) $composite .= '<' . $html['tag'] . $spacer . $attributes . '>';
        if ( myIsset( $html['tag_content'] ) ) $composite .= $html['tag_content'];

    } else if($tmp == 'close') {
        if ( myIsset( $html['tag_content'] ) ) $composite .= $html['tag_content'];
        if ( myIsset( $html['tag'] ) ) $composite .= '</' . $html['tag'] . '>';
    } else if($tmp ==  'attributes') {
        $composite = $attributes;
    } else {
        if ( myIsset( $html['tag'] ) ) $composite .= '<' . $html['tag'] . $spacer . $attributes . '>';
        if ( myIsset( $html['tag_content'] ) ) $composite .= $html['tag_content'];
        if ( myIsset( $html['tag'] ) ) $composite .= '</' . $html['tag'] . '>';
    }

    if ( myIsset( $html['tag_content_after'] ) ) $composite .= $html['tag_content_after'];

    if ( $html['return'] == true ) return $composite ;

    echo $composite;
    return null;
}

/*
 * adapted from https://github.com/stephenharris/Event-Organiser/blob/master/includes/event-organiser-utility-functions.php
 */
function _eventorganiser_remove_duplicates( $array ) {
    //Do we need to worry about the myTimes of the date-myTime objects?
    if( myEmpty($array) )
        return $array;
    $unique = array();
    foreach ($array as $key=>$object) {
        if( !myInArray($object, $unique) )
            $unique[$key] = $object;
        }
        return $unique;
}

/*
 * adapted from https://github.com/stephenharris/Event-Organiser/blob/master/includes/event-organiser-utility-functions.php
 */
function _eventorganiser_compare_datemyTime( $date1, $date2 ) {

    if ( $date1 == $date2 ) {
        return 0;
    } else if ( $date1 > $date2 ) {
        return 1;
    } else {
        return -1;
    }

}

/*
 * copied from https://developer.wordpress.org/reference/functions/absint/
 */
function absint( $maybeint ) {
    return abs( (int) $maybeint );
}

//20 ----------------------------

/*
 * copied from https://developer.wordpress.org/reference/functions/add_cssclass/
 */
function add_cssclass($add, $class) {
    $class = myEmpty($class) ? $add : $class .= ' ' . $add;
    return $class;
}

function is_admin() {return false;}
function is_rtl() {return true;}
function add_theme_support($x) { $x.'1'; return null;}

/**
 * adapted from https://developer.wordpress.org/reference/functions/add_editor_style/
 */
function add_editor_style( array $stylesheet, array $editor_styles) {
    add_theme_support( 'editor-style' );

    if ( ! is_admin() )
        return;

    if ( is_rtl() ) {
        $rtl_stylesheet = str_replace('.css', '-rtl.css', $stylesheet[0]);
        $stylesheet[myCount($stylesheet)] = $rtl_stylesheet;
    }

    $editor_styles = myArrayMerge( $editor_styles, $stylesheet );
    return null;
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/zeroise/
 */
function zeroise( $number, $threshold ) {
    return mySprintf( '%0' . $threshold . 's', $number );
}

/**
 * adapted from https://developer.wordpress.org/reference/functions/antispambot/
 */
function antispambot( $email_address, $hex_encoding ) {
    $email_no_spam_address = '';
    for ( $i = 0, $len = myStrLen( $email_address ); $i < $len; $i++ ) {
        $j = myRand( 0, 1 + $hex_encoding );
        if ( $j == 0 ) {
            $email_no_spam_address .= '&#' . myOrd( $email_address[$i] ) . ';';
        } else if ( $j == 1 ) {
            $email_no_spam_address .= $email_address[$i];
        } else if ( $j == 2 ) {
            $email_no_spam_address .= '%' . zeroise( myDechex( myOrd( $email_address[$i] ) ), 2 );
        }
    }

    return str_replace( '@', '&#64;', $email_no_spam_address );
}



/*
 * Copied from https://developer.wordpress.org/reference/functions/allowed_tags/
 */
function allowed_tags($allowedtags) {
    $allowed = '';
    foreach ( (array) $allowedtags as $tag => $attributes ) {
        $allowed .= '<'.$tag;
        if ( 0 < myCount($attributes) ) {
            foreach ( $attributes as $attribute => $limits ) {
                $allowed .= ' '.$attribute.'=""';
            }
        }
        $allowed .= '> ';
    }
    return myHtmlEntities( $allowed );
}



function apply_filters($tag, $value, $var) {
    $tag.'a';
    return null;
}

function home_url() {
    return 'http://...';
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/wp_validate_redirect/
 */
function wp_validate_redirect($location, $default) {
    $location = myTrim( $location );
    // browsers will assume 'http' is your protocol, and will obey a redirect to a URL starting with '//'
    if ( mySubstr($location, 0, 2) == '//' )
        $location = 'http:' . $location;

    // In php 5 myParseUrl may fail if the URL query part contains http://, bug #38143
    $test = ( $cut = myStrPos($location, '?') ) ? mySubstr( $location, 0, $cut ) : $location;

    $lp  = myParseUrl($test);

    // Give up if malformed URL
    if ( false === $lp )
        return $default;

    // Allow only http and https schemes. No data:, etc.
    if ( myIsset($lp['scheme']) && !('http' == $lp['scheme'] || 'https' == $lp['scheme']) )
        return $default;

    // Reject if scheme is set but host is not. This catches urls like https:host.com for which myParseUrl does not set the host field.
    if ( myIsset($lp['scheme'])  && !myIsset($lp['host']) )
        return $default;

    $wpp = myParseUrl(home_url());

    /**
     * Filter the whitelist of hosts to redirect to.
     *
     * @since 2.3.0
     *
     * @param array       $hosts An array of allowed hosts.
     * @param bool|string $host  The parsed host; empty if not isset.
     */
    $allowed_hosts = (array) apply_filters( 'allowed_redirect_hosts', array($wpp['host']), myIsset($lp['host']) ? $lp['host'] : '' );

    if ( myIsset($lp['host']) && ( !myInArray($lp['host'], $allowed_hosts) && $lp['host'] != myStrToLower($wpp['host'])) )
        $location = $default;

    return $location;
}

/**
 * adapted from https://developer.wordpress.org/reference/functions/backslashit/
 */
function backslashit( $string ) {
    if ( myIsset( $string[0] ) && $string[0] >= '0' && $string[0] <= '9' )
        $string = '\\\\' . $string;
    return myAddCSlashes( $string, 'A..Za..z' );
}

function get_option($option) {
    return $option;
}


/*
 * https://developer.wordpress.org/reference/functions/balancetags/
 */
function balanceTags( $text, $force) {
    if ( $force || get_option('use_balanceTags') == 1 ) {
        return force_balance_tags( $text );
    } else {
        return $text;
    }
}

/**
 * adapted from https://developer.wordpress.org/reference/functions/backslashit/
 */
function force_balance_tags( $text ) {
    $tagstack = array();
    $stacksize = 0;
    $tagqueue = '';
    $newtext = '';
    // Known single-entity/self-closing tags
    $single_tags = array( 'area', 'base', 'basefont', 'br', 'col', 'command', 'embed', 'frame', 'hr', 'img', 'input', 'isindex', 'link', 'meta', 'param', 'source' );
    // Tags that can be immediately nested within themselves
    $nestable_tags = array( 'blockquote', 'div', 'object', 'q', 'span' );

    // WP bug fix for comments - in case you REALLY meant to type '< !--'
    $text = str_replace('< !--', '<    !--', $text);
    // WP bug fix for LOVE <3 (and other situations with '<' before a number)
    $text = myPregReplace('#<([0-9]{1})#', '&lt;$1', $text);

    $regex=[];
    while ( myPregMatch("/<(\/?[\w:]*)\s*([^>]*)>/", $text, $regex) ) {
        $newtext .= $tagqueue;

        $i = myStrPos($text, $regex[0]);
        $l = myStrLen($regex[0]);

        // clear the shifter
        $tagqueue = '';
        // Pop or Push
        if ( myIsset($regex[1][0]) && '/' == $regex[1][0] ) { // End Tag
            $tag = myStrToLower(mySubstr2($regex[1],1));
            // if too many closing tags
            if ( $stacksize <= 0 ) {
                $tag = '';
                // or close to be safe $tag = '/' . $tag;
            }
            // if stacktop value = tag close value then pop
            else if ( $tagstack[$stacksize - 1] == $tag ) { // found closing tag
                $tag = '</' . $tag . '>'; // Close Tag
                // Pop
                myArrayPop( $tagstack );
                $stacksize--;
            } else { // closing tag not at top, search for it
                for ( $j = $stacksize-1; $j >= 0; $j-- ) {
                    if ( $tagstack[$j] == $tag ) {
                    // add tag to tagqueue
                        for ( $k = $stacksize-1; $k >= $j; $k--) {
                            $tagqueue .= '</' . myArrayPop( $tagstack ) . '>';
                            $stacksize--;
                        }
                        break;
                    }
                }
                $tag = '';
            }
        } else { // Begin Tag
            $tag = myStrToLower($regex[1]);

            // Tag Cleaning

            // If it's an empty tag "< >", do nothing
            if ( '' == $tag ) {
                // do nothing
            }
            // ElseIf it presents itself as a self-closing tag...
            else if ( mySubstr2( $regex[2], -1 ) == '/' ) {
                // ...but it isn't a known single-entity self-closing tag, then don't let it be treated as such and
                // immediately close it with a closing tag (the tag will encapsulate no text as a result)
                if ( ! myInArray( $tag, $single_tags ) )
                    $regex[2] = myTrim( mySubstr( $regex[2], 0, -1 ) ) . '></'.$tag;
            }
            // ElseIf it's a known single-entity tag but it doesn't close itself, do so
            else if ( myInArray($tag, $single_tags) ) {
                $regex[2] .= '/';
            }
            // Else it's not a single-entity tag
            else {
                // If the top of the stack is the same as the tag we want to push, close previous tag
                if ( $stacksize > 0 && !myInArray($tag, $nestable_tags) && $tagstack[$stacksize - 1] == $tag ) {
                    $tagqueue = '</' . myArrayPop( $tagstack ) . '>';
                    $stacksize--;
                }
                $stacksize = myArrayPush( $tagstack, $tag );
            }

            // Attributes
            $attributes = $regex[2];
            if ( ! myEmpty( $attributes ) && $attributes[0] != '>' )
                $attributes = ' ' . $attributes;

            $tag = '<' . $tag . $attributes . '>';
            //If already queuing a close tag, then put this tag on, too
            if ( !myEmpty($tagqueue) ) {
                $tagqueue .= $tag;
                $tag = '';
            }
        }
        $newtext .= mySubstr($text, 0, $i) . $tag;
        $text = mySubstr2($text, $i + $l);
    }

    // Clear Tag Queue
    $newtext .= $tagqueue;

    // Add Remaining text
    $newtext .= $text;

    // Empty Stack
    while( $x = myArrayPop($tagstack) )
        $newtext .= '</' . $x . '>'; // Add remaining tags to close

    // WP fix for the bug with HTML comments
    $newtext = str_replace("< !--","<!--",$newtext);
    $newtext = str_replace("<    !--","< !--",$newtext);

    return $newtext;
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/before_last_bar/
 */
function before_last_bar( $string ) {
    $last_bar = myStrRpos( $string, '|' );
    if ( false === $last_bar )
        return $string;
    else
        return mySubstr( $string, 0, $last_bar );
}

//30------------------------------

function get_body_class($class){
  return [1];
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/body_class/
 */
function body_class( $class ) {
    // Separates classes with a single space, collates classes for body element
    echo 'class="' . myJoin( ' ', get_body_class( $class ) ) . '"';
    return null;
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/bool_from_yn/
 */
function bool_from_yn( $yn ) {
    return ( myStrToLower( $yn ) == 'y' );
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/calendar_week_mod/
 */
function calendar_week_mod($num) {
    $base = 7;
    return ($num - $base*floor($num/$base));
}

function current_filter() {
    return 'filter';
}

function _x($text, $context){
  return $text.$context;
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/capital_p_dangit/
 */
function capital_P_dangit( $text ) {
    // Simple replacement for titles
    $current_filter = current_filter();
    if ( 'the_title' === $current_filter || 'wp_title' === $current_filter )
        return str_replace( 'Wordpress', 'WordPress', $text );
    // Still here? Use the more judicious replacement
    $dblq = false;
    if ( false === $dblq ) {
        $dblq = _x( '&#8220;', 'opening curly double quote' );
    }
    return str_replace(
        array( ' Wordpress', '&#8216;Wordpress', $dblq . 'Wordpress', '>Wordpress', '(Wordpress' ),
        array( ' WordPress', '&#8216;WordPress', $dblq . 'WordPress', '>WordPress', '(WordPress' ),
    $text );
}



function term_exists($term, $taxonomy, $parent){
    if ($parent % 20) {
        return'id';
    } else if($taxonomy.'a'.$term.'a' == 'banana') {
        return ['term1','term2'];
    }
    return null;
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/category_exists/
 */
function category_exists( $cat_name, $parent ) {
    $id = term_exists($cat_name, 'category', $parent);
    if ( myIsArray($id) )
        $id = $id['term_id'];
    return $id;
}

/*
 * copied from https://developer.wordpress.org/reference/functions/convert_invalid_entities/
 */
function convert_invalid_entities( $content ) {
    $wp_htmltranswinuni = array(
        '&#128;' => '&#8364;' // the Euro sign
        //...
    );

    if ( myStrPos( $content, '&#1' ) !== false ) {
        $content = myStrtr( $content, $wp_htmltranswinuni );
    }

    return $content;
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/convert_smilies/
 */
function convert_smilies( $text, $wp_smiliessearch ) {
    $output = '';
    if ( get_option( 'use_smilies' ) && ! myEmpty( $wp_smiliessearch ) ) {
        // HTML loop taken from texturize function, could possible be consolidated
        $textarr = myPregSplit( '/(<.*>)/U', $text, -1, 1 ); // capture the tags as well as in between
        $stop = myCount( $textarr );// loop stuff

        // Ignore proessing of specific tags
        $tags_to_ignore = 'code|pre|style|script|textarea';
        $ignore_block_element = '';

        for ( $i = 0; $i < $stop; $i++ ) {
            $content = $textarr[$i];

            $matches = [];
            // If we're in an ignore block, wait until we find its closing tag
            if ( '' == $ignore_block_element && myPregMatch( '/^<(' . $tags_to_ignore . ')>/', $content, $matches ) )  {
                $ignore_block_element = $matches[1];
            }

            // If it's not a tag and not in ignore block
            if ( '' ==  $ignore_block_element && myStrLen( $content ) > 0 && '<' != $content[0] ) {
               // $content = preg_replace_callback( $wp_smiliessearch, 'translate_smiley', $content );
            }

            // did we exit ignore block
            if ( '' != $ignore_block_element && '</' . $ignore_block_element . '>' == $content )  {
                $ignore_block_element = '';
            }

            $output .= $content;
        }
    } else {
        // return default text.
        $output = $text;
    }
    return $output;
}

/*
 * adapted from https://developer.wordpress.org/reference/functions/current_time/
 */
function current_myTime( $type, $gmt = 0 ) {
    switch ( $type ) {
        case 'mysql':
            return ( $gmt ) ? myGmDate( 'Y-m-d H:i:s' , myTime()) : myGmDate( 'Y-m-d H:i:s', ( myTime() + ( get_option( 'gmt_offset' ) * 60 * 60 ) ) );
        case 'myTimestamp':
            return ( $gmt ) ? myTime() : myTime() + ( get_option( 'gmt_offset' ) * 60 * 60 );
        default:
            return ( $gmt ) ? myDate( $type , myTime()) : myDate( $type, myTime() + ( get_option( 'gmt_offset' ) * 60 * 60 ) );
    }
}

//38 ------------

/***************** A* implementation, **********
 * found here http://granularreverb.com/a_star.php
 * And slightly adapted (by-ref is not yet supported) - some variables were forward reference usages and other bugs
 */

// A* algorithm by aaz, found at
// http://althenia.net/svn/stackoverflow/a-star.php?rev=7
// Binary min-heap with element values stored separately

//original code: function heap_float(&$heap, &$values, $i, $index) {
function heap_float($heap, $values, $i, $index) {
    $j = 0;
    for (; $i; $i = $j) {
        $j = ($i + $i%2)/2 - 1;
        if ($values[$heap[$j]] < $values[$index])
            break;
        $heap[$i] = $heap[$j];
    }
    $heap[$i] = $index;
    return null;
}

//original code: function heap_push(&$heap, &$values, $index) {
function heap_push($heap, $values, $index) {
    heap_float($heap, $values, myCount($heap), $index);
    return null;
}

//original code: function heap_raise(&$heap, &$values, $index) {
function heap_raise($heap, $values, $index) {
    heap_float($heap, $values, myArraySearch($index, $heap), $index);
    return null;
}

//original code: function heap_pop(&$heap, &$values) {
function heap_pop($heap, $values) {
    $front = $heap[0];
    $index = myArrayPop($heap);
    $n = myCount($heap);
    if ($n) {
        $j = 0;
        for ($i = 0;; $i = $j) {
            $j = $i*2 + 1;
            if ($j >= $n)
                break;
            if ($j+1 < $n && $values[$heap[$j+1]] < $values[$heap[$j]])
                $j += 1;
            if ($values[$index] < $values[$heap[$j]])
                break;
            $heap[$i] = $heap[$j];
        }
        $heap[$i] = $index;
    }
    return $front;
}


// A-star algorithm:
//   $start, $target - node indexes
//   $neighbors($i)     - map of neighbor index => step cost
//   $heuristic($i, $j) - minimum cost between $i and $j

function a_star($start, $target, $map) {
    $open_heap = array($start); // binary min-heap of indexes with values in $f
    $open      = array($start => TRUE); // set of indexes
    $closed    = array();               // set of indexes

    $g = [];
    $h = [];
    $f = [];
    $from = [];

    $g[$start] = 0;
    $h[$start] = heuristic($start, $target);
    $f[$start] = $g[$start] + $h[$start];

    while ($open) {
        $i = heap_pop($open_heap, $f);
        //not yet supported
        //unset($open[$i]);
        $open[$i] = null;
        $closed[$i] = TRUE;

        if ($i == $target) {
            $path = array();
            for (; $i != $start; $i = $from[$i])
                $path[myCount($path)] = $i;
            return myArrayReverse($path);
        }

        foreach (neighbors($i, $map) as $j => $step)
            if (!myArrayKeyExists($j, $closed))
                if (!myArrayKeyExists($j, $open) || $g[$i] + $step < $g[$j]) {
                    $g[$j] = $g[$i] + $step;
                    $h[$j] = heuristic($j, $target);
                    $f[$j] = $g[$j] + $h[$j];
                    $from[$j] = $i;

                    if (!myArrayKeyExists($j, $open)) {
                        $open[$j] = TRUE;
                        heap_push($open_heap, $f, $j);
                    } else
                        heap_raise($open_heap, $f, $j);
                }
    }

    return FALSE;
}

const NODE_WIDTH = 51;
const NODE_HEIGHT = 23;

function node($x, $y) {
    return $y * NODE_WIDTH + $x;
}

function coord($i) {
    $x = $i % NODE_WIDTH;
    $y = ($i - $x) / NODE_WIDTH;
    return array($x, $y);
}

function neighbors($i, $map) {
    $arr = coord($i);
    $x = $arr[0];
    $y = $arr[1];
    $neighbors = array();
    if ($x-1 >= 0      && $map[$y][$x-1] == ' ') $neighbors[node($x-1, $y)] = 1;
    if ($x+1 < NODE_WIDTH  && $map[$y][$x+1] == ' ') $neighbors[node($x+1, $y)] = 1;
    if ($y-1 >= 0      && $map[$y-1][$x] == ' ') $neighbors[node($x, $y-1)] = 1;
    if ($y+1 < NODE_HEIGHT && $map[$y+1][$x] == ' ') $neighbors[node($x, $y+1)] = 1;
    return $neighbors;
}

function heuristic($i, $j) {
    $arr_i = coord($i);
    $arr_j = coord($j);
    return abs($arr_i[0] - $arr_j[0]) + abs($arr_i[1] - $arr_j[1]);
}

function a_star_test(){
    $map = myArrayFill(0, NODE_HEIGHT, myStrRepeat('A', NODE_WIDTH));
    generate(node(myRand(1, (NODE_WIDTH +NODE_WIDTH %2)/2-1)*2-1,
                  myRand(1, (NODE_HEIGHT+NODE_HEIGHT%2)/2-1)*2-1), $map);

    $start  = node(1, 1);
    $target = node(NODE_WIDTH+NODE_WIDTH%2-3, NODE_HEIGHT+NODE_HEIGHT%2-3);

    $path = a_star($start, $target, $map);

    myArrayUnshift($path, $start);
    foreach ($path as $i) {
        $arr = coord($i);
        $map[$arr[0]][$arr[1]] = '*';
    }
    return null;
}

function generate($i, $map) {
    $arr = coord($i);
    $x = $arr[0];
    $y = $arr[1];
    $map[$x][$y] = ' ';
    $next = array();
    if ($x-2 > 0)         $next[myCount($next)] = array(-2, 0);
    if ($x+2 < NODE_WIDTH-1)  $next[myCount($next)] = array(+2, 0);
    if ($y-2 > 0)         $next[myCount($next)] = array(0, -2);
    if ($y+2 < NODE_HEIGHT-1) $next[myCount($next)] = array(0, +2);
    myShuffle($next);
    foreach ($next as $d)
        if ($map[$y+$d[1]  ][$x+$d[0]  ] != ' ') {
            $map[$y+$d[1]/2][$x+$d[0]/2]  = ' ';
            generate(node($x+$d[0], $y+$d[1]), $map);
        }
    return null;
}

function display_maze($map) {
    foreach ($map as $line) {
      echo str_replace("A","<span></span>",str_replace("*","<img src='google_smile.gif' width='12' height='12'>",$line))."\n";
    }
    return null;
}

// 50 -----------------------

/***********   start test functions ***************/

function megamorphicAdd(
	$a1,  $a2,  $a3,  $a4,  $a5,
	$a6,  $a7,  $a8,  $a9,  $a10,
	$a11, $a12, $a13, $a14, $a15,
	$a16, $a17, $a18, $a19, $a20) {

	return $a1  + $a2  + $a3  + $a4  + $a5
		+ $a6  + $a7  + $a8  + $a9  + $a10
		+ $a11 + $a12 + $a13 + $a14 + $a15
		+ $a16 + $a17 + $a18 + $a19 + $a20;
}

function endless(){
    return endless();
}

//direct recursive functions and soft typing
function test(array $a){
    $a = $a > 1 ? test($a - 1) : 0;
    return $a;
}

//parametric polymorphic direct recursive function
function fibGen($n){
    return $n > 0 ? fibGen($n-1) + fibGen($n-2) : $n;
}

function add($x, $y) {
    return $x + $y;
}

function fib($n) {
    return $n > 0 ? fib($n - 1) + fib($n - 2) : 1;
}

function fac($n) {
    return $n > 0 ? $n * fac($n) : $n;
}

function startsWith($text, $value) {
    return myStrPos($text, $value) === 0;
}

function withImplicitReturn($x) {
    if ($x) {
       return $x + 1;
    }
}

function wrapIt($value, $wrapIt) {
    if ($wrapIt) {
        return [$value];
    }
    return $value;
}

// 10 (total 60) -------------------------------

/* Fallback to soft typing required */
function addOne($x) {
    if (myIsArray($x)) {
        return $x + [1];
    }
    return $x + 1;
}

function typeHintAndDataPolymorphism(array $x, $key) {
    $x = $x[$key];
    return $x + 1;
}

function identity($x) {
    return $x;
}

function convertibleToString($x) {
    echo $x;
    return identity($x);
}

function asStringReturnString($x) {
    echo $x;
    return (string) $x;
}

function countValue(array $arr, $value) {
    $count = 0;
    for ($i = 0; $i < myCount($arr); ++$i) {
        if ($arr[$i] == $value) {
            ++$count;
        }
    }
    return $count;
}

function isEven($x) {
   return $x % 2 == 0;
}

function isOdd($x) {
   return $x % 2 == 1;
}

function someLogic($x, $y, $z) {
    $a = $x || $y && !$z;
    $b = !$x or $y xor $z and $a;
    return $a == $b;
}

function orExit($x) {
    $x or exit(-1);
    return null;
}

//20 (total 70)-------------------------------

function andExit($x) {
    $x and exit(0);
    return null;
}


function bitwise1($x, $y, $z) {
    return $x & $y | $z;
}

function bitwise2($x, $y, $z) {
    return $x << 2 & ($y >> 1) ^ $z;
}

function arithmetic1($x, $y, $z) {
    return ($x + $y) * $z / 2;
}

function arithmetic2($x, $y, $z) {
    return abs(+($x / -$y) % $z);
}

function array1($x, $y) {
    $x[0] = $y;
    return $x;
}

function array2(array $x, $y) {
    $x + $y;
    return $x[3];
}

//30 (total 80) ------------------------------

function combi1($x, $y, $z){
    $a = myTruncate($x, 12, 10, $z);
    $email = encode_email($a, 'blabla', 123);
    show_gravatar($email, $y, 'pic', 'good');
    return $a;
}

function combi2($x, $y, $z){
    $a = myAddCSlashes($x, 'a..z');
    $b = str_replace($a, $y, $z);
    return myHtmlEntities($a);
}

function combi3($x){
    $password1 = generate_rand(12);
    $password2 = readable_random_string($_GET['number']);
    return myArrayMerge([$password1], [$password2]);
}

function combi4($x, $y, $z){
    $a = isEven($x);
    $b = isOdd($y);
    return someLogic($a, $b, $z);;
}

function combi5($x, $y, $z){
    $a = combi1($x, 'a', 'b');
    $b = combi2($y, 'c', 'd');
    $c = combi3($z);
    return combi4($a, $b, $c);
}

function combi6($x, $y, $z){
    return bitwise1($x, bitwise2(1, $y, 3), 4);
}

function combi7($x, $y, $z){
    if($x > 10){
        return arithmetic1(1.2, $y, abs(1)) / $z;
    }
    return false;
}

function combi8($x, $y){
    $a = eo_php2xdate($y);
    myArrayPush($y, $a);
    return fnbx_html_tag($y);
}

function combi9($x, $y){
    $a = myOrd($x) + myOrd($y);
    $b = myParseUrl('result is: '.$a);
    return asStringReturnString(myTrim($b));
}

function combi10($w, $x, $y, $z){
    $a = countValue($x, $y);
    $b = myArrayMerge($x, $z);
    myArrayPush($b, 12);
    $c = countValue($b, $y);
    return ($a - $c) / $w;
}

//40 (total 90) -------------------

/********** start indirect recursive functions ******************/

function foo8($x){
    if($x > 0){
        return bar8($x-1);
    }
    return $x;
}

function bar8($x){
    if($x > 0){
        return foo8($x-1);
    }
    return $x;
}

// indirect recursive function with parameter which has no constraint other than recursive function,
// hence will not have a binding during the first iteration
function foo9($x) {
    return bar9($x);
}

function bar9($x){
    if($x > 0){
        return foo9($x-1);
    }
    return $x;
}

// indirect recursive function which does not change during first iteration,
// dependent function changes though
function foo10($x){
    return foo10B($x);
}

function foo10B($x){
    return bar10($x);
}

function bar10($x){
    if($x > 0){
        return foo10($x-1);
    }
    return $x;
}

//
function foo11($x, $y){
    return $x > 0 ?  bar11($x & $y, $y) : $x;
}

function bar11($x, $y){
    return $x > 10 ? foo11($x - $y, $y) : $y;
}

//
function foo1($x, $y){
    return bar1($x, $y);
}

function bar1($x, $y){
    return $x > 10 ? foo1($x - $y, $y) : $y;
}

//
function foo14($x, $y){
    return $x > 0 ?  bar14($x + $y, $y) : $x;
}

function bar14($x, $y){
    return $x > 10 ? foo14($x , $y) : $y;
}

//indirect recursive function which produces more overloads once
//the dependent function is known.
function foo3($x, $y){
    return bar3($x, $y);
}

function bar3($x, $y){
    return $x > 10 ? foo3($x + $y, $y) : $y;
}

//
function foo($x, $y){
    if($x){
        return $y;
    }
    return bar($y);
}

function bar($x){
    if($x > 0){
        return foo(false, $x);
    }
    return $x;
}

//
function foo17($x, $y){
    return bar17($x, $y);
}

function bar17($x, $y){
    return $x > 10 ? foo17($x + $y, $y) : $y;
}

//
function foo17B($x, $y){
    return bar17B($x, $y);
}

function bar17B($x, $y){
    return $x > 10 ? foo17B($x, $x + $y) : $y;
}


//10 ---------------------------- indirect recursive function groups

?>