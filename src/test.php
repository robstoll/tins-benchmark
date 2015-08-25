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
?>