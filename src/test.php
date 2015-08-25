<?php

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
    return strpos($text, $value) === 0;
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

/* Fallback to soft typing required */
function addOne($x) {
    if (is_array($x)) {
        return $x + [1];
    }
    return $x + 1;
}

function typeHintAndDataPolymorphism(array $x, $key){
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

//10 -----------

function asStringReturnString($x){
    echo $x;
    return (string) $x;
}

function countValue(array $arr, $value) {
    $count = 0;
    for ($i = 0; $i < count($arr); ++$i) {
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

function someLogic($x, $y, $z){
    $a = $x || $y && !$z;
    $b = !$x or $y xor $z and $a;
    return $a == $b;
}

function orExit($x){
    $x or exit(-1);
    return null;
}

function andExit($x){
    $x and exit(0);
    return null;
}

/**
 * adapted from
 * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
 */
function readable_random_string($length){
     $conso=array('b','c','d','f','g','h','j','k','l',
     'm','n','p','r','s','t','v','w','x','y','z');
     $vocal=array('a','e','i','o','u');
     $password='';
     srand((double)microtime()*1000000);
     $max = $length/2;

     for($i=1; $i <= $max; $i++){
        $password .= $conso[rand(0,19)];
        $password .= $vocal[rand(0,4)];
     }

     return $password;
}

/**
 * adapted from
 * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
 */
function generate_rand($l){
  $c= ['A','B','C','D','E','F','G','H','I','J','K', 'L','M',
    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
    'a','b','c','d','e','f','g','h','i','j','k','l','m',
    'n','o','p','q','r','s','t','u','v','w','x','y','z',
    '0','1','2','3','4','5','6','7','8','9'];
  srand((double)microtime()*1000000);
  $rand = '';
  for($i=0; $i<$l; $i++) {
      $rand.= $c[rand(0,1)%count($c)];
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
    $email = str_split($email, 5);

    $linkText = str_replace('@', '&#64;', $linkText);
    $linkText = str_replace('.', '&#46;', $linkText);
    $linkText = str_split($linkText, 5);

    $part1 = '<a href="ma';
    $part2 = 'ilto&#58;';
    $part3 = '" '. $attrs .' >';
    $part4 = '</a>';

    $encoded = '<script type="text/javascript">';
    $encoded .= 'document.write(\''.$part1.'\');';
    $encoded .= 'document.write(\''.$part2.'\');';

    foreach(str_split($email, 1) as $e)
    {
        $encoded .= 'document.write(\''.$e.'\');';
    }

    $encoded .= 'document.write(\''.$part3.'\');';
    foreach(str_split($linkText, 1) as $l)
    {
        $encoded .= 'document.write(\''.$l.'\');';
    }

    $encoded .= 'document.write(\''.$part4.'\');';
    $encoded .= '</script>';

    return $encoded;
}

//20 -----------

/**
 * adapted from
 * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
 */
function show_gravatar($email, $size, $default, $rating)
{
    echo '<img src="http://www.gravatar.com/avatar.php?gravatar_id='.asStringReturnString($email).
        '&default='.$default.'&size='.$size.'&rating='.$rating.'" width="'.$size.'px"
        height="'.$size.'px" />';
}


// Original PHP code by Chirp Internet: www.chirp.com.au
// Please acknowledge use of this code by including this header.
function myTruncate($string, $limit, $break=".", $pad="...") {
    // return with no change if string is shorter than $limit
    if(strlen($string) <= $limit)
        return $string;

    // is $break present between $limit and the end of the string?
    if(false !== ($breakpoint = strpos($string, $break, $limit))) {
        if($breakpoint < strlen($string) - 1) {
            $string = substr($string, 0, $breakpoint) . $pad;
        }
    }
    return $string;
}

function bitwise1($x, $y, $z){
    return $x & $y | $z;
}

function bitwise2($x, $y, $z){
    return $x << 2 & ($y >> 1) ^ $z;
}

function arithmetic1($x, $y, $z){
    return ($x + $y) * $z / 2;
}

function arithmetic2($x, $y, $z){
    return abs(+($x / -$y) % $z);
}


/**
 * adapted from https://github.com/stephenharris/Event-Organiser/blob/master/includes/event-organiser-utility-functions.php
 */
function eo_php2xdate($phpformat=""){
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
    for($i=0;  $i< strlen($phpformat); $i++){
        //Handle backslash excape
        if($phpformat[$i]=="\\"){
            $xdateformat .= "'".$phpformat[$i+1]."'";
            $i++;
            continue;
        }
        if(isset($php2xdate[$phpformat[$i]])){
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

    if ( empty( $html ) ) return;

    $attributes = '';
    $composite = '';
    $spacer = '';
    if ( !isset( $html['return'] ) ) $html['return'] = false;
    $reserved = array(
        'tag', 'tag_type', 'attributes', 'tag_content', 'tag_content_before', 'tag_content_after', 'return'
    );

    foreach ( $html as $name => $option ) {
        if ( in_array( $name, $reserved ) ) continue;
        $attributes .= $name . '="' . $option . '" ';
    }

    if ( isset( $html['attributes'] ) ) $attributes .= $html['attributes'] . ' ' . $attributes;

    if ( $attributes != '' ) {
        $attributes = rtrim( $attributes );
        $spacer = ' ';
    }

    if ( !isset( $html['tag_type'] ) ) $html['tag_type'] = 'default';

    if ( isset( $html['tag_content_before'] ) ) $composite .= $html['tag_content_before'];

    $tmp = $html['tag_type'];
    if($tmp  == 'single' ) {
        if ( isset( $html['tag_content'] ) ) $composite .= $html['tag_content'];
        if ( isset( $html['tag'] ) ) $composite .= '<' . $html['tag'] . $spacer . $attributes . '/>';
    } else if($tmp == 'open'){
        if ( isset( $html['tag'] ) ) $composite .= '<' . $html['tag'] . $spacer . $attributes . '>';
        if ( isset( $html['tag_content'] ) ) $composite .= $html['tag_content'];

    } else if($tmp == 'close'){
        if ( isset( $html['tag_content'] ) ) $composite .= $html['tag_content'];
        if ( isset( $html['tag'] ) ) $composite .= '</' . $html['tag'] . '>';
    } else if($tmp ==  'attributes'){
        $composite = $attributes;
    } else {
        if ( isset( $html['tag'] ) ) $composite .= '<' . $html['tag'] . $spacer . $attributes . '>';
        if ( isset( $html['tag_content'] ) ) $composite .= $html['tag_content'];
        if ( isset( $html['tag'] ) ) $composite .= '</' . $html['tag'] . '>';
    }

    if ( isset( $html['tag_content_after'] ) ) $composite .= $html['tag_content_after'];

    if ( $html['return'] == true ) return $composite ;

    echo $composite;
    return null;
}

function array1($x, $y){
    $x[0] = $y;
    return $x;
}

function array2(array $x, $y){
    $x + $y;
    return $x[3];
}

//30 -----------


?>