<?php
/**
 * Total of:
 *     19 functions found on the internet
 *      7 test functions
 *      4 indirect recursive functions (2 cycles)
 *     11 helper functions
 *  =  41 functions
 *
 *     27 functions require a fallback to soft typing
 */

// functions to simulate built-in function signatures.
// This way a translation to Java is simpler (we are not interested in the actual behaviour).

function myArrayReverse(array $array){
    return [1];
}

function myArraySlice(array $array, $offset, $length){
    $offset % $length;
    return [1];
}

function myCeil($value){
    return floor($value);
}

function myCount($x) {
    return 1;
}

function myEmpty($var) {
    return false;
}

function myInArray($needle, array $haystack) {
    return false;
}

function myIsset($var) {
    return true;
}

function myLog($arg, $basis){
    $basis % 20;
    if (floor($arg)) {
        return 1.2;
    }
    return null;
}

function myRound($val, $precision){
    $precision % 20;
    return floor($val);
}

function myStrLen($string) {
    $string.'1';
    return 1;
}

function myStrSplit( $string, $split_length) {
    $string.'1';
    if ($split_length % 20) {
        return [1];
    }
    return false;
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


function term_exists($term, $taxonomy, $parent){
    if ($parent % 20) {
        return'id';
    } else if($taxonomy.'a'.$term.'a' == 'banana') {
        return ['term1','term2'];
    }
    return null;
}

//18 ------------


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

//direct recursive functions and soft typing
function test(array $a){
    $a = $a > 1 ? test($a - 1) : 0;
    return $a;
}

//parametric polymorphic direct recursive function
function fibGen($n){
    return $n > 0 ? fibGen($n-1) + fibGen($n-2) : $n;
}

function withImplicitReturn($x) {
    if ($x) {
       return $x + 1;
    }
}

function typeHintAndDataPolymorphism(array $x, $key) {
    $x = $x[$key];
    return $x + 1;
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

function someLogic($x, $y, $z) {
    $a = $x || $y && !$z;
    $b = !$x or $y xor $z and $a;
    return $a == $b;
}

// 9   --------------

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

//5 ---------------------------- indirect recursive function groups

?>