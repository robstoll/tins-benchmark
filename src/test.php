<?php

function add($x, $y){
    return $x + $y;
}

function fib($n){
    return $n > 0 ? fib($n - 1) + fib($n - 2) : 1;
}
/*
function fac($n){
    return $n > 0 ? $n * fac($n) : $n;
}*/
?>