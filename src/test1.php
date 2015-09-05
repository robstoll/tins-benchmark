<?php
/**
 * Total of:
 *     33 functions found on the internet
 *      9 test functions
 *     11 indirect recursive functions (10 cycles)
 *     29 helper functions
 *  = 82 functions
 *
 *     27 functions require a fallback to soft typing
 */

// functions to simulate built-in function signatures.
// This way a translation to Java is simpler (we are not interested in the actual behaviour).

function myArrayKeyExists($key, array $array){
    return true;
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

function myIsArray($var) {
    return true;
}

function myLog($arg, $basis){
    $basis % 20;
    if (floor($arg)) {
        return 1.2;
    }
    return null;
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

function myRound($val, $precision){
    $precision % 20;
    return floor($val);
}

function myShuffle(array $array){
    return true;
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


//20 ----------------------------


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

//22 ------------

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

// 22 + 11 = 33 -----------------------


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

function arithmetic1($x, $y, $z) {
    return ($x + $y) * $z / 2;
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

//5 ---------------------------- indirect recursive function groups

?>