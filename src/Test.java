import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "UnusedDeclaration"})
public class Test
{

    public static void main(String[] args) {
        System.out.println(null instanceof Object);

    }

    //------------------

    public static String myAddCSlashes(Object $str, Object $charlist) {
        return String.valueOf($str) + String.valueOf($charlist);
    }

    public static boolean myArrayKeyExists(Object $key, Map $array) {
        return true;
    }

    public static Map myArrayFill(Object $start_index, Object $num, Object $value) {
        int i = asInt($start_index) % asInt($num);
        return new HashMap();
    }

    public static Map myArrayMerge(Map $a, Map $b) {
        Map c = new HashMap($a);
        c.putAll($b);
        return c;
    }

    public static Object myArrayPop(Map $array) {
        int $count = myCount($array);
        if ($count > 0) {
            return $array.remove($count - 1);
        }
        return null;
    }

    public static int myArrayPush(Map $array, Object $value) {
        return 1;
    }

    public static Map myArrayReverse(Map $array) {
        return new HashMap();
    }

    public static Object myArraySearch(Object $needle, Map $haystack) {
        return $haystack.get(0);
    }

    public static Map myArraySlice(Map $array, Object $offset, Object $length) {
        mod($offset, $length);
        return new HashMap();
    }

    public static int myArrayUnshift(Map $array, Object $value) {
        return 1;
    }

    private static Object floor(Object $value) {
        return $value;
    }

    public static Object myCeil(Object $value) {
        return floor($value);
    }

    public static int myCount(Map $x) {
        return 1;
    }

    public static String myDate(Object $format, Object $timestamp) {
        mod($timestamp, 20);
        return String.valueOf($format) + "a";
    }

    public static String myDechex(Object $number) {
        mod($number, 20);
        return "f";
    }

    public static boolean myEmpty(Object $var) {
        return false;
    }

    public static String myGmDate(String $format, Object $timestamp) {
        return myDate($format, $timestamp);
    }

    public static String myHtmlEntities(Object $string) {
        return String.valueOf($string) + "1";
    }

    public static boolean myInArray(Object $needle, Map $haystack) {
        return false;
    }

    public static boolean myIsset(Object $var) {
        return true;
    }

    public static boolean myIsArray(Object $var) {
        return true;
    }

    public static String myJoin(Object $glue, Map $pieces) {
        return String.valueOf($glue) + "a";
    }

    public static Double myLog(Object $arg, Object $basis) {
        mod($basis, 20);
        if (asBool(floor($arg))) {
            return 1.2;
        }
        return null;
    }

    public static String myMicrotime() {
        return "12345678";
    }

    public static int myOrd(Object $string) {
        String s = String.valueOf($string) + "a";
        return 1;
    }

    public static Object myParseUrl(Object $url) {
        if (!String.valueOf($url).equals("")) {
            return String.valueOf($url) + "a";
        }
        return false;
    }

    public static Object myPregMatch(Object $pattern, Object $subject, Map $matches) {
        if (asBool(String.valueOf($pattern) + String.valueOf($subject))) {
            return 1;
        }
        return false;
    }

    private static Object str_replace(Object $pattern, Object $replacement, Object $subject) {
        //only a dummy
        return String.valueOf($pattern).replace(String.valueOf($replacement), String.valueOf($subject));
    }

    public static Object myPregReplace(Object $pattern, Object $replacement, Object $subject) {
        return str_replace($pattern, $replacement, $subject);
    }

    public static Map myPregSplit(Object $pattern, Object $subject, Object $limit, Object $flags) {
        String s = String.valueOf($pattern) + String.valueOf($subject);
        int i = asInt($limit) % asInt($flags);
        return new HashMap();
    }

    public static int myRand(Object $min, Object $max) {
        mod($min, $max);
        return 1;
    }

    public static Object myRound(Object $val, Object $precision) {
        mod($precision, 20);
        return floor($val);
    }

    public static Void mySRand(Object $seed) {
        mod($seed, 20);
        return null;
    }

    public static boolean myShuffle(Map $array) {
        return true;
    }

    public static String mySprintf(Object $format, Object $arg) {
        return String.valueOf($format) + String.valueOf($arg);
    }

    public static int myStrLen(Object $string) {
        String s = String.valueOf($string) + String.valueOf("1");
        return 1;
    }

    public static Object myStrPos(Object $haystack, Object $needle) {
        if (asBool(String.valueOf($haystack) + "a")) {
            return 1;
        }
        return false;
    }

    public static Object myStrPos2(Object $haystack, Object $needle, Object $limit) {
        mod($limit, 20);
        return myStrPos($haystack, $needle);
    }

    public static Object myStrRpos(Object $haystack, Object $needle) {
        return myStrPos($haystack, $needle);
    }

    public static String myStrRepeat(Object $input, Object $multiplier) {
        mod($multiplier, 1);
        return String.valueOf($input) + "a";
    }

    public static Object myStrSplit(Object $string, Object $split_length) {
        String s = String.valueOf($string) + "1";
        if (asBool(mod($split_length, 20))) {
            return new HashMap();
        }
        return false;
    }

    public static String myStrtr(Object $str, Object $from) {
        return String.valueOf($str) + String.valueOf($from);
    }

    public static String myStrToLower(Object $string) {
        return String.valueOf($string) + "a";
    }

    public static Object mySubstr(Object $string, Object $start, Object $length) {
        String s = String.valueOf($string) + "a";
        mod($start, 20);
        mod($length, 20);
        if (asInt($start) < asInt($length)) {
            return "hey";
        }
        return false;
    }

    public static Object mySubstr2(Object $string, Object $start) {
        mod($start, 20);
        if (asBool(String.valueOf($string) + "a")) {
            return "hey";
        }
        return false;
    }

    public static int myTime() {
        return 1;
    }

    public static String myTrim(Object $str) {
        return String.valueOf($str) + "1";
    }

    public static String myRTrim(Object $str) {
        return String.valueOf($str) + "1";
    }

//--------------

    /*
     * copied from https://phpcoderblog.wordpress
.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
     */
    public static Map bubbleSort(Map $arr) {
        int $n = myCount($arr);
        for (int $i = 1; $i < $n; $i++) {
            for (int $j = $n - 1; $j >= $i; $j--) {
                if (((Comparable) $arr.get($j - 1)).compareTo($arr.get($j)) > 0) {
                    Object $tmp = $arr.get($j - 1);
                    $arr.put($j - 1, $arr.get($j));
                    $arr.put($j, $tmp);
                }
            }
        }

        return $arr;
    }

    /*
     * copied from https://phpcoderblog.wordpress
.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
     */
    public static Map bubbleSortImproved(Map $arr) {
        int $n = myCount($arr);
        for (int $i = 1; $i < $n; $i++) {
            boolean $flag = false;
            for (int $j = $n - 1; $j >= $i; $j--) {
                if (((Comparable) $arr.get($j - 1)).compareTo($arr.get($j)) > 0) {
                    Object $tmp = $arr.get($j - 1);
                    $arr.put($j - 1, $arr.get($j));
                    $arr.put($j, $tmp);
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
     * copied from https://phpcoderblog.wordpress
.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
     */
    public static Map selectionSort(Map $arr) {
        int $n = myCount($arr);
        for (int $i = 0; $i < $n; $i++) {
            int $lowestValueIndex = $i;
            Object $lowestValue = $arr.get($i);
            for (int $j = $i + 1; $j < $n; $j++) {
                if (((Comparable) $arr.get($j)).compareTo($lowestValue) < 0) {
                    $lowestValueIndex = $j;
                    $lowestValue = $arr.get($j);
                }
            }

            $arr.put($lowestValueIndex, $arr.get($i));
            $arr.put($i, $lowestValue);
        }

        return $arr;
    }

    /*
     * copied from https://phpcoderblog.wordpress
.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
     */
    public static Map countingSort(Map $arr) {
        int $n = myCount($arr);
        Map $p = new HashMap();
        Map $sorted = new HashMap();

        for (int $i = 0; $i < $n; $i++) {
            $p.put($i, 0);
        }

        for (int $i = 0; $i < $n; $i++) {
            for (int $j = $i + 1; $j < $n; $j++) {
                if (((Comparable) $arr.get($i)).compareTo($arr.get($j)) > 0) {
                    oldSchoolIncrement($p.get($i));
                } else {
                    oldSchoolIncrement($p.get($j));
                }
            }
        }

        for (int $i = 0; $i < $n; $i++) {
            $sorted.put($p.get($i), $arr.get($i));
        }

        return $sorted;
    }

    /*
     * copied from https://phpcoderblog.wordpress
.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
     */
    public static Map quicksort(Map $arr, Object $left, Object $right) {
        Object $i = $left;
        Object $j = $right;
        Object $separator = $arr.get(floor(oldSchoolDivide(oldSchoolAddition($left, $right), 2)));

        while (((Comparable) $i).compareTo($j) <= 0) {
            while (((Comparable) $arr.get($i)).compareTo($separator) < 0) {
                $i = oldSchoolAddition($i, 1);
            }

            while (((Comparable) $arr.get($j)).compareTo($separator) > 0) {
                $j = oldSchoolSubtraction($j, 1);
            }

            if (((Comparable) $i).compareTo($j) <= 0) {
                Object $tmp = $arr.get($i);
                $arr.put($i, $arr.get($j));
                $arr.put($j, $tmp);
                $i = oldSchoolAddition($i, 1);
                $j = oldSchoolSubtraction($j, 1);
            }
        }

        if (((Comparable) $left).compareTo($j) < 0) {
            $arr = quicksort($arr, $left, $j);
        }

        if (((Comparable) $right).compareTo($i) > 0) {
            $arr = quicksort($arr, $i, $right);
        }

        return $arr;
    }

    /*
     * copied from https://phpcoderblog.wordpress
.com/2013/02/26/php-some-sorting-algorithms-bubble-sort-selection-sort-counting-sort-quicksort-shellsort-heapsort/
     */
    public static Map shellsort(Map $arr) {
        int $n = myCount($arr);
        int $t = asInt(myCeil(myLog($n, 2)));
        Map $d = new HashMap();
        $d.put(0, 0);
        $d.put(0, 1);
        for (int $i = 2; $i <= $t; $i++) {
            $d.put($i, oldSchoolAddition(oldSchoolMultiply(2, $d.get($i - 1)), 1));
        }

        $d = myArrayReverse($d);
        for (Object $curIncrement : $d.values()) {
            for (int $i = asInt($curIncrement); $i < $n; $i++) {
                Object $x = $arr.get($i);
                int $j = $i - asInt($curIncrement);
                while ($j >= 0 && ((Comparable) $x).compareTo($arr.get($j)) < 0) {
                    $arr.put($j + asInt($curIncrement), $arr.get($j));
                    $j = $j - asInt($curIncrement);
                }
                $arr.put($j + asInt($curIncrement), $x);
            }
        }
        return $arr;
    }

    /*
    * adapted from http://infopotato.com/blog/index/binary_search
    */
    public static Object binary_search(Object $x, Map $list, Number $left, Number $right) {
        if (((Comparable) $left).compareTo($right) > 0) {
            return -1;
        }

        Object $mid = oldSchoolDivide(oldSchoolAddition($left, $right), 2);

        if ($list.get($mid) == $x) {
            return $mid;
        } else if (((Comparable) $list.get($mid)).compareTo($x) > 0) {
            return binary_search($x, $list, $left, oldSchoolSubtraction($mid, 1));
        } else if (((Comparable) $list.get($mid)).compareTo($x) < 0) {
            return binary_search($x, $list, oldSchoolAddition($mid, 1), $right);
        }
        return null;
    }

    /*
     * adapted from http://infopotato.com/blog/index/binary_search
     */
    public static Object binary_search_iterative(Object $x, Map $list) {
        Number $left = 0;
        Number $right = myCount($list) - 1;

        while (((Comparable) $left).compareTo($right) <= 0) {
            Object $mid = oldSchoolDivide(oldSchoolAddition($left, $right), 2);

            if ($list.get($mid) == $x) {
                return $mid;
            } else if (((Comparable) $list.get($mid)).compareTo($x) > 0) {
                $right = oldSchoolSubtraction($mid, 1);
            } else if (((Comparable) $list.get($mid)).compareTo($x) < 0) {
                $left = oldSchoolAddition($mid, 1);
            }
        }

        return -1;
    }


    /*
     * adapted from https://github.com/technopagan/Computer-Science-Algorithms/blob/master/sorting/merge-sort
-algorithm.php
     */
    public static Map mergesort(Map $data) {
        // Only process if we"re not down to one piece of data
        if (myCount($data) > 1) {

            // Find out the middle of the current data set and split it there to obtain to halfs
            Object $data_middle = myRound(oldSchoolIntDivide(myCount($data), 2), 0);
            // and now for some recursive magic
            Map $data_part1 = mergesort(myArraySlice($data, 0, $data_middle));
            Map $data_part2 = mergesort(myArraySlice($data, $data_middle, myCount($data)));
            // Setup counters so we can remember which piece of data in each half we"re looking at
            int $counter2;
            int $counter1 = $counter2 = 0;
            // iterate over all pieces of the currently processed array, compare size & reassemble
            for (int $i = 0; $i < myCount($data); $i++) {
                // if we"re done processing one half, take the rest from the 2nd half
                if ($counter1 == myCount($data_part1)) {
                    $data.put($i, $data_part2.get($counter2));
                    ++$counter2;
                    // if we"re done with the 2nd half as well or as long as pieces in the first half are still
                    // smaller than the 2 nd half
                } else if (($counter2 == myCount($data_part2)) || (((Comparable) $data_part1.get($counter1))
                        .compareTo($data_part2.get($counter2)) < 0)) {
                    $data.put($i, $data_part1.get($counter1));
                    ++$counter1;
                } else {
                    $data.put($i, $data_part2.get($counter2));
                    ++$counter2;
                }
            }
        }
        return $data;
    }

    /*
     * adapted from https://algorithmik.wordpress.com/2012/11/26/insertion-sort-algorithm-php-implementation-2/
     */
    public static Map insertionSort(Map $array) {
        int $length = myCount($array);
        for (int $i = 1; $i < $length; $i++) {
            Object $element = $array.get($i);
            int $j = $i;
            while ($j > 0 && ((Comparable) $array.get($j - 1)).compareTo($element) > 0) {
                //move value to right and key to previous smaller index
                $array.put($j, $array.get($j - 1));
                $j = $j - 1;
            }
            //put the element at index $j
            $array.put($j, $element);
        }
        return $array;
    }

//10 -----------

    /**
     * adapted from
     * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
     */
    public static String readable_random_string(Object $length) {
        Map $conso = new HashMap();
        $conso.put(0, "b");
        $conso.put(1, "c");
        $conso.put(2, "d");
        $conso.put(3, "f");
        $conso.put(4, "g");
        $conso.put(5, "h");
        $conso.put(6, "j");
        $conso.put(7, "k");
        $conso.put(8, "l");
        $conso.put(9, "m");
        $conso.put(10, "n");
        $conso.put(11, "p");
        $conso.put(12, "r");
        $conso.put(13, "s");
        $conso.put(14, "t");
        $conso.put(15, "v");
        $conso.put(16, "w");
        $conso.put(17, "x");
        $conso.put(18, "y");
        $conso.put(19, "z");
        Map $vocal = new HashMap();
        $vocal.put(0, "a");
        $vocal.put(1, "e");
        $vocal.put(2, "i");
        $vocal.put(3, "o");
        $vocal.put(4, "u");
        String $password = "";
        mySRand(Double.parseDouble(myMicrotime()) * 1000000);
        Object $max = oldSchoolDivide($length, 2);

        for (int $i = 1; ((Comparable) $i).compareTo($max) <= 0; $i++) {
            $password += $conso.get(myRand(0, 19));
            $password += $vocal.get(myRand(0, 4));
        }

        return $password;
    }

    /**
     * adapted from
     * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
     */
    public static String generate_rand(Object $l) {
        Map $c = new HashMap();
        $c.put(0, "A");
        $c.put(1, "B");
        $c.put(2, "C");
        $c.put(3, "D");
        $c.put(4, "E");
        $c.put(5, "F");
        $c.put(6, "G");
        $c.put(7, "H");
        $c.put(8, "I");
        $c.put(9, "J");
        $c.put(10, "K");
        $c.put(11, "L");
        $c.put(12, "M");
        $c.put(13, "N");
        $c.put(14, "O");
        $c.put(15, "P");
        $c.put(16, "Q");
        $c.put(17, "R");
        $c.put(18, "S");
        $c.put(19, "T");
        $c.put(20, "U");
        $c.put(21, "V");
        $c.put(22, "W");
        $c.put(23, "X");
        $c.put(24, "Y");
        $c.put(25, "Z");
        $c.put(26, "a");
        $c.put(27, "b");
        $c.put(28, "c");
        $c.put(29, "d");
        $c.put(30, "e");
        $c.put(31, "f");
        $c.put(32, "g");
        $c.put(33, "h");
        $c.put(34, "i");
        $c.put(35, "j");
        $c.put(36, "k");
        $c.put(37, "l");
        $c.put(38, "m");
        $c.put(39, "n");
        $c.put(40, "o");
        $c.put(41, "p");
        $c.put(42, "q");
        $c.put(43, "r");
        $c.put(44, "s");
        $c.put(45, "t");
        $c.put(46, "u");
        $c.put(47, "v");
        $c.put(48, "w");
        $c.put(49, "x");
        $c.put(50, "y");
        $c.put(51, "z");
        $c.put(52, "0");
        $c.put(53, "1");
        $c.put(54, "2");
        $c.put(55, "3");
        $c.put(56, "4");
        $c.put(57, "5");
        $c.put(58, "6");
        $c.put(59, "7");
        $c.put(60, "8");
        $c.put(61, "9");
        mySRand(Double.parseDouble(myMicrotime()) * 1000000);
        String $rand = "";
        for (int $i = 0; ((Comparable) $i).compareTo($l) < 0; $i++) {
            $rand += $c.get(myRand(0, 1) % myCount($c));
        }
        return $rand;
    }

    /**
     * adapted from
     * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
     */
    public static String encode_email(Object $email, Object $linkText, Object $attrs) {
        $email = str_replace("@", "&#64;", $email);
        $email = str_replace(".", "&#46;", $email);
        $email = myStrSplit($email, 5);

        $linkText = str_replace("@", "&#64;", $linkText);
        $linkText = str_replace(".", "&#46;", $linkText);
        $linkText = myStrSplit($linkText, 5);

        String $part1 = "<a href=\" ma ";
        String $part2 = "ilto&#58;";
        String $part3 = "\" " + String.valueOf($attrs) + " > ";
        String $part4 = "</a>";

        String $encoded = "<script type=\" text / javascript \">";
        $encoded += "document.write(\"" + $part1 + "\");";
        $encoded += "document.write(\"" + $part2 + "\");";

        for (Object $e : ((Map) myStrSplit($email, 1)).values()) {
            $encoded += "document.write(\"" + String.valueOf($e) + "\");";
        }

        $encoded += "document.write(\"" + $part3 + "\");";
        for (Object $l : ((Map) myStrSplit($linkText, 1)).values()) {
            $encoded += "document.write(\"" + String.valueOf($l) + "\");";
        }

        $encoded += "document.write(\"" + $part4 + "\");";
        $encoded += "</script>";

        return $encoded;
    }

    /**
     * adapted from
     * http://webdeveloperplus.com/php/21-really-useful-handy-php-code-snippets/
     */
    public static Void show_gravatar(Object $email, Object $size, Object $default, Object $rating) {
        System.out.println("<img src=\" http://www.gravatar.com/avatar.php?gravatar_id=" + String.valueOf($email)
                + "&default=" + String.valueOf($default)
                + "&size=" + String.valueOf($size)
                + "&rating=" + String.valueOf($rating) + "\" "
                + "width = \"" + String.valueOf($size) + "px\" height = \"" + String.valueOf($size) + "px\" / > ");
        return null;
    }


    // Original PHP code by Chirp Internet: www.chirp.com.au
// Please acknowledge use of this code by including this header.
    public static Object myTruncate(Object $string, Object $limit, Object $break, Object $pad) {
        // return with no change if string is shorter than $limit
        if (((Comparable) myStrLen($string)).compareTo($limit) <= 0) {
            return $string;
        }

        Object $breakpoint;
        // is $break present between $limit and the end of the string?
        if (false != ($breakpoint = myStrPos2($string, $break, $limit))) {
            if (((Comparable) $breakpoint).compareTo(myStrLen($string) - 1) < 0) {
                $string = String.valueOf(mySubstr($string, 0, $breakpoint)) + $pad;
            }
        }
        return $string;
    }

    /**
     * adapted from https://github.com/stephenharris/Event-Organiser/blob/master/includes/event-organiser-utility
     * -public statics.php
     */
    public static String eo_php2xdate(Object $phpformat) {
        Map $php2xdate = new HashMap();
        $php2xdate.put("Y", "yyyy");
        $php2xdate.put("y", "yy");
        $php2xdate.put("L", ""/*Not Supported*/);
        $php2xdate.put("o", "I");
        $php2xdate.put("j", "d");
        $php2xdate.put("d", "dd");
        $php2xdate.put("D", "ddd");
        $php2xdate.put("l", "dddd");
        $php2xdate.put("N", "" /*NS*/);
        $php2xdate.put("S", "S");
        $php2xdate.put("w", "" /*NS*/);
        $php2xdate.put("z", "" /*NS*/);
        $php2xdate.put("W", "w");
        $php2xdate.put("F", "MMMM");
        $php2xdate.put("m", "MM");
        $php2xdate.put("M", "MMM");
        $php2xdate.put("n", "M");
        $php2xdate.put("t", ""/*NS*/);
        $php2xdate.put("a", "tt");
        $php2xdate.put("A", "TT");
        $php2xdate.put("B", ""/*NS*/);
        $php2xdate.put("g", "h");
        $php2xdate.put("G", "H");
        $php2xdate.put("h", "hh");
        $php2xdate.put("H", "HH");
        $php2xdate.put("u", "fff");
        $php2xdate.put("i", "mm");
        $php2xdate.put("s", "ss");
        $php2xdate.put("O", "zz ");
        $php2xdate.put("P", "zzz");
        $php2xdate.put("c", "u");

        String $xdateformat = "";
        for (int $i = 0; $i < myStrLen($phpformat); $i++) {
            //Handle backslash excape
            if (String.valueOf($phpformat).charAt($i) == '\\') {
                $xdateformat += "\" " + String.valueOf($phpformat).charAt($i + 1) + " \"";
                $i++;
                continue;
            }
            if (myIsset($php2xdate.get(String.valueOf($phpformat).charAt($i)))) {
                $xdateformat += $php2xdate.get(String.valueOf($phpformat).charAt($i));
            } else {
                $xdateformat += String.valueOf($phpformat).charAt($i);
            }
        }
        return $xdateformat;
    }

    /**
     * adapted from https://gist.github.com/ev3rywh3re/4573482
     */
    public static String fnbx_html_tag(Map $html) {

        if (myEmpty($html)) {
            return null;
        }

        String $attributes = "";
        String $composite = "";
        String $spacer = "";
        if (!myIsset($html.get("return"))) {
            $html.put("return", false);
        }
        Map $reserved = new HashMap();
        $reserved.put(1, "tag");
        $reserved.put(2, "tag_type");
        $reserved.put(3, "attributes");
        $reserved.put(4, "tag_content");
        $reserved.put(5, "tag_content_before");
        $reserved.put(6, "tag_content_after");
        $reserved.put(7, "return");

        Set<Map.Entry> set = $html.entrySet();
        for (Map.Entry<Object, Object> entry : set) {
            Object $name = entry.getKey();
            Object $option = entry.getValue();
            if (myInArray($name, $reserved)) {
                continue;
            }
            $attributes += $name + "=\" " + String.valueOf($option) + " \" ";
        }

        if (myIsset($html.get("attributes"))) {
            $attributes += String.valueOf($html.get("attributes")) + " " + $attributes;
        }


        if (!$attributes.equals("")) {
            $attributes = myRTrim($attributes);
            $spacer = " ";
        }

        if (!myIsset($html.get("tag_type"))) {
            $html.put("tag_type", "default");
        }

        if (myIsset($html.get("tag_content_before"))) {
            $composite += $html.get("tag_content_before");
        }

        Object $tmp = $html.get("tag_type");
        if ($tmp == "single") {
            if (myIsset($html.get("tag_content"))) {
                $composite += String.valueOf($html.get("tag_content"));
            }
            if (myIsset($html.get("tag"))) {
                $composite += "<" + String.valueOf($html.get("tag")) + $spacer + $attributes + "/>";
            }
        } else if ($tmp == "open") {
            if (myIsset($html.get("tag"))) {
                $composite += "<" + String.valueOf($html.get("tag")) + $spacer + $attributes + ">";
            }
            if (myIsset($html.get("tag_content"))) {
                $composite += String.valueOf($html.get("tag_content"));
            }

        } else if ($tmp == "close") {
            if (myIsset($html.get("tag_content"))) {
                $composite += String.valueOf($html.get("tag_content"));
            }
            if (myIsset($html.get("tag"))) {
                $composite += "</" + String.valueOf($html.get("tag")) + ">";
            }
        } else if ($tmp == "attributes") {
            $composite = $attributes;
        } else {
            if (myIsset($html.get("tag"))) {
                $composite += "<" + String.valueOf($html.get("tag")) + $spacer + $attributes + ">";
            }
            if (myIsset($html.get("tag_content"))) {
                $composite += String.valueOf($html.get("tag_content"));
            }
            if (myIsset($html.get("tag"))) {
                $composite += "</" + String.valueOf($html.get("tag")) + ">";
            }
        }

        if (myIsset($html.get("tag_content_after"))) {
            $composite += String.valueOf($html.get("tag_content_after"));
        }

        if (asBool($html.get("return")) == true) {
            return $composite;
        }

        System.out.println($composite);
        return null;
    }

    /*
     * adapted from https://github.com/stephenharris/Event-Organiser/blob/master/includes/event-organiser-utility
     * -public statics.php
     */
    public static Map _eventorganiser_remove_duplicates(Map $array) {
        //Do we need to worry about the myTimes of the date-myTime objects?
        if (myEmpty($array)) {
            return $array;
        }
        Map $unique = new HashMap();
        Set<Map.Entry> set = $array.entrySet();
        for (Map.Entry entry : set) {
            Object $key = entry.getKey();
            Object $object = entry.getValue();
            if (!myInArray($object, $unique)) {
                $unique.put($key, $object);
            }
        }
        return $unique;
    }

    /*
     * adapted from https://github.com/stephenharris/Event-Organiser/blob/master/includes/event-organiser-utility
     * -public statics.php
     */
    public static int _eventorganiser_compare_datemyTime(Object $date1, Object $date2) {

        if ($date1 == $date2) {
            return 0;
        } else if (((Comparable) $date1).compareTo($date2) > 0) {
            return 1;
        } else {
            return -1;
        }

    }

    /*
     * copied from https://developer.wordpress.org/reference/public statics/absint/
     */
    public static int absint(Object $maybeint) {
        return Math.abs(asInt($maybeint));
    }

//20 ----------------------------
//
//    /*
//     * copied from https://developer.wordpress.org/reference/public statics/add_cssclass/
//     */
//    public static add_cssclass($add, $class) {
//        $class = myEmpty($class) ? $add : $class .= " " . $add;
//        return $class;
//    }
//
//    public static is_admin() {return false;}
//    public static is_rtl() {return true;}
//    public static add_theme_support($x) { $x."1"; return null;}
//
//    /**
//     * adapted from https://developer.wordpress.org/reference/public statics/add_editor_style/
//     */
//    public static add_editor_style( array $stylesheet, array $editor_styles) {
//        add_theme_support( "editor-style" );
//
//        if ( ! is_admin() )
//            return;
//
//        if ( is_rtl() ) {
//            $rtl_stylesheet = str_replace(".css", "-rtl.css", $stylesheet[0]);
//            $stylesheet[myCount($stylesheet)] = $rtl_stylesheet;
//        }
//
//        $editor_styles = myArrayMerge( $editor_styles, $stylesheet );
//        return null;
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/zeroise/
//     */
//    public static zeroise( $number, $threshold ) {
//        return mySprintf( "%0" . $threshold . "s", $number );
//    }
//
//    /**
//     * adapted from https://developer.wordpress.org/reference/public statics/antispambot/
//     */
//    public static antispambot( $email_address, $hex_encoding = 0 ) {
//        $email_no_spam_address = "";
//        for ( $i = 0, $len = myStrLen( $email_address ); $i < $len; $i++ ) {
//            $j = myRand( 0, 1 + $hex_encoding );
//            if ( $j == 0 ) {
//                $email_no_spam_address .= "&#" . myOrd( $email_address[$i] ) . ";";
//            } else if ( $j == 1 ) {
//                $email_no_spam_address .= $email_address[$i];
//            } else if ( $j == 2 ) {
//                $email_no_spam_address .= "%" . zeroise( myDechex( myOrd( $email_address[$i] ) ), 2 );
//            }
//        }
//
//        return str_replace( "@", "&#64;", $email_no_spam_address );
//    }
//
//
//
//    /*
//     * Copied from https://developer.wordpress.org/reference/public statics/allowed_tags/
//     */
//    public static allowed_tags($allowedtags) {
//        $allowed = "";
//        foreach ( (array) $allowedtags as $tag => $attributes ) {
//            $allowed .= "<".$tag;
//            if ( 0 < myCount($attributes) ) {
//                foreach ( $attributes as $attribute => $limits ) {
//                    $allowed .= " ".$attribute."=""";
//                }
//            }
//            $allowed .= "> ";
//        }
//        return myHtmlEntities( $allowed );
//    }
//
//
//
//    public static apply_filters($tag, $value, $var) {
//        $tag."a";
//        return null;
//    }
//
//    public static home_url() {
//        return "http://...";
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/wp_validate_redirect/
//     */
//    public static wp_validate_redirect($location, $default = "") {
//        $location = myTrim( $location );
//        // browsers will assume "http" is your protocol, and will obey a redirect to a URL starting with "//"
//        if ( mySubstr($location, 0, 2) == "//" )
//            $location = "http:" . $location;
//
//        // In php 5 myParseUrl may fail if the URL query part contains http://, bug #38143
//        $test = ( $cut = myStrPos($location, "?") ) ? mySubstr( $location, 0, $cut ) : $location;
//
//        $lp  = myParseUrl($test);
//
//        // Give up if malformed URL
//        if ( false === $lp )
//            return $default;
//
//        // Allow only http and https schemes. No data:, etc.
//        if ( myIsset($lp["scheme"]) && !("http" == $lp["scheme"] || "https" == $lp["scheme"]) )
//            return $default;
//
//        // Reject if scheme is set but host is not. This catches urls like https:host.com for which myParseUrl does
// not set the host field.
//        if ( myIsset($lp["scheme"])  && !myIsset($lp["host"]) )
//            return $default;
//
//        $wpp = myParseUrl(home_url());
//
//        /**
//         * Filter the whitelist of hosts to redirect to.
//         *
//         * @since 2.3.0
//         *
//         * @param array       $hosts An array of allowed hosts.
//         * @param bool|string $host  The parsed host; empty if not isset.
//         */
//        $allowed_hosts = (array) apply_filters( "allowed_redirect_hosts", array($wpp["host"]),
// myIsset($lp["host"]) ? $lp["host"] : "" );
//
//        if ( myIsset($lp["host"]) && ( !myInArray($lp["host"], $allowed_hosts) && $lp["host"] != myStrToLower
// ($wpp["host"])) )
//            $location = $default;
//
//        return $location;
//    }
//
//    /**
//     * adapted from https://developer.wordpress.org/reference/public statics/backslashit/
//     */
//    public static backslashit( $string ) {
//        if ( myIsset( $string[0] ) && $string[0] >= "0" && $string[0] <= "9" )
//            $string = "\\\\" . $string;
//        return myAddCSlashes( $string, "A..Za..z" );
//    }
//
//    public static get_option($option) {
//        return $option;
//    }
//
//
//    /*
//     * https://developer.wordpress.org/reference/public statics/balancetags/
//     */
//    public static balanceTags( $text, $force = false ) {
//        if ( $force || get_option("use_balanceTags") == 1 ) {
//            return force_balance_tags( $text );
//        } else {
//            return $text;
//        }
//    }
//
//    /**
//     * adapted from https://developer.wordpress.org/reference/public statics/backslashit/
//     */
//    public static force_balance_tags( $text ) {
//        $tagstack = array();
//        $stacksize = 0;
//        $tagqueue = "";
//        $newtext = "";
//        // Known single-entity/self-closing tags
//        $single_tags = array( "area", "base", "basefont", "br", "col", "command", "embed", "frame", "hr", "img",
// "input", "isindex", "link", "meta", "param", "source" );
//        // Tags that can be immediately nested within themselves
//        $nestable_tags = array( "blockquote", "div", "object", "q", "span" );
//
//        // WP bug fix for comments - in case you REALLY meant to type "< !--"
//        $text = str_replace("< !--", "<    !--", $text);
//        // WP bug fix for LOVE <3 (and other situations with "<" before a number)
//        $text = myPregReplace("#<([0-9]{1})#", "&lt;$1", $text);
//
//        $regex=[];
//        while ( myPregMatch("/<(\/?[\w:]*)\s*([^>]*)>/", $text, $regex) ) {
//            $newtext .= $tagqueue;
//
//            $i = myStrPos($text, $regex[0]);
//            $l = myStrLen($regex[0]);
//
//            // clear the shifter
//            $tagqueue = "";
//            // Pop or Push
//            if ( myIsset($regex[1][0]) && "/" == $regex[1][0] ) { // End Tag
//                $tag = myStrToLower(mySubstr2($regex[1],1));
//                // if too many closing tags
//                if ( $stacksize <= 0 ) {
//                    $tag = "";
//                    // or close to be safe $tag = "/" . $tag;
//                }
//                // if stacktop value = tag close value then pop
//                else if ( $tagstack[$stacksize - 1] == $tag ) { // found closing tag
//                    $tag = "</" . $tag . ">"; // Close Tag
//                    // Pop
//                    myArrayPop( $tagstack );
//                    $stacksize--;
//                } else { // closing tag not at top, search for it
//                    for ( $j = $stacksize-1; $j >= 0; $j-- ) {
//                        if ( $tagstack[$j] == $tag ) {
//                            // add tag to tagqueue
//                            for ( $k = $stacksize-1; $k >= $j; $k--) {
//                                $tagqueue .= "</" . myArrayPop( $tagstack ) . ">";
//                                $stacksize--;
//                            }
//                            break;
//                        }
//                    }
//                    $tag = "";
//                }
//            } else { // Begin Tag
//                $tag = myStrToLower($regex[1]);
//
//                // Tag Cleaning
//
//                // If it"s an empty tag "< >", do nothing
//                if ( "" == $tag ) {
//                    // do nothing
//                }
//                // ElseIf it presents itself as a self-closing tag...
//                else if ( mySubstr2( $regex[2], -1 ) == "/" ) {
//                    // ...but it isn"t a known single-entity self-closing tag, then don"t let it be treated as such
// and
//                    // immediately close it with a closing tag (the tag will encapsulate no text as a result)
//                    if ( ! myInArray( $tag, $single_tags ) )
//                        $regex[2] = myTrim( mySubstr( $regex[2], 0, -1 ) ) . "></".$tag;
//                }
//                // ElseIf it"s a known single-entity tag but it doesn"t close itself, do so
//                else if ( myInArray($tag, $single_tags) ) {
//                    $regex[2] .= "/";
//                }
//                // Else it"s not a single-entity tag
//                else {
//                    // If the top of the stack is the same as the tag we want to push, close previous tag
//                    if ( $stacksize > 0 && !myInArray($tag, $nestable_tags) && $tagstack[$stacksize - 1] == $tag ) {
//                        $tagqueue = "</" . myArrayPop( $tagstack ) . ">";
//                        $stacksize--;
//                    }
//                    $stacksize = myArrayPush( $tagstack, $tag );
//                }
//
//                // Attributes
//                $attributes = $regex[2];
//                if ( ! myEmpty( $attributes ) && $attributes[0] != ">" )
//                    $attributes = " " . $attributes;
//
//                $tag = "<" . $tag . $attributes . ">";
//                //If already queuing a close tag, then put this tag on, too
//                if ( !myEmpty($tagqueue) ) {
//                    $tagqueue .= $tag;
//                    $tag = "";
//                }
//            }
//            $newtext .= mySubstr($text, 0, $i) . $tag;
//            $text = mySubstr2($text, $i + $l);
//        }
//
//        // Clear Tag Queue
//        $newtext .= $tagqueue;
//
//        // Add Remaining text
//        $newtext .= $text;
//
//        // Empty Stack
//        while( $x = myArrayPop($tagstack) )
//            $newtext .= "</" . $x . ">"; // Add remaining tags to close
//
//        // WP fix for the bug with HTML comments
//        $newtext = str_replace("< !--","<!--",$newtext);
//        $newtext = str_replace("<    !--","< !--",$newtext);
//
//        return $newtext;
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/before_last_bar/
//     */
//    public static before_last_bar( $string ) {
//        $last_bar = myStrRpos( $string, "|" );
//        if ( false === $last_bar )
//            return $string;
//        else
//            return mySubstr( $string, 0, $last_bar );
//    }
//
////30------------------------------
//
//    public static get_body_class($class){
//        return [1];
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/body_class/
//     */
//    public static body_class( $class = "" ) {
//        // Separates classes with a single space, collates classes for body element
//        echo "class="" . myJoin( " ", get_body_class( $class ) ) . """;
//        return null;
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/bool_from_yn/
//     */
//    public static bool_from_yn( $yn ) {
//        return ( myStrToLower( $yn ) == "y" );
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/calendar_week_mod/
//     */
//    public static calendar_week_mod($num) {
//        $base = 7;
//        return ($num - $base*floor($num/$base));
//    }
//
//    public static current_filter() {
//        return "filter";
//    }
//
//    public static _x($text, $context){
//        return $text.$context;
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/capital_p_dangit/
//     */
//    public static capital_P_dangit( $text ) {
//        // Simple replacement for titles
//        $current_filter = current_filter();
//        if ( "the_title" === $current_filter || "wp_title" === $current_filter )
//            return str_replace( "Wordpress", "WordPress", $text );
//        // Still here? Use the more judicious replacement
//        $dblq = false;
//        if ( false === $dblq ) {
//            $dblq = _x( "&#8220;", "opening curly double quote" );
//        }
//        return str_replace(
//                array( " Wordpress", "&#8216;Wordpress", $dblq . "Wordpress", ">Wordpress", "(Wordpress" ),
//        array( " WordPress", "&#8216;WordPress", $dblq . "WordPress", ">WordPress", "(WordPress" ),
//        $text );
//    }
//
//
//
//    public static term_exists($term, $taxonomy, $parent){
//        $term."a";
//        $taxonomy."a";
//        $parent % 20;
//        return "id";
//        return null;
//        return ["term1","term2"];
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/category_exists/
//     */
//    public static category_exists( $cat_name, $parent = null ) {
//        $id = term_exists($cat_name, "category", $parent);
//        if ( myIsArray($id) )
//            $id = $id["term_id"];
//        return $id;
//    }
//
//    /*
//     * copied from https://developer.wordpress.org/reference/public statics/convert_invalid_entities/
//     */
//    public static convert_invalid_entities( $content ) {
//        $wp_htmltranswinuni = array(
//                "&#128;" => "&#8364;" // the Euro sign
//        //...
//        );
//
//        if ( myStrPos( $content, "&#1" ) !== false ) {
//            $content = myStrtr( $content, $wp_htmltranswinuni );
//        }
//
//        return $content;
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/convert_smilies/
//     */
//    public static convert_smilies( $text, $wp_smiliessearch ) {
//        $output = "";
//        if ( get_option( "use_smilies" ) && ! myEmpty( $wp_smiliessearch ) ) {
//            // HTML loop taken from texturize public static, could possible be consolidated
//            $textarr = myPregSplit( "/(<.*>)/U", $text, -1, 1 ); // capture the tags as well as in between
//            $stop = myCount( $textarr );// loop stuff
//
//            // Ignore proessing of specific tags
//            $tags_to_ignore = "code|pre|style|script|textarea";
//            $ignore_block_element = "";
//
//            for ( $i = 0; $i < $stop; $i++ ) {
//                $content = $textarr[$i];
//
//                $matches = [];
//                // If we"re in an ignore block, wait until we find its closing tag
//                if ( "" == $ignore_block_element && myPregMatch( "/^<(" . $tags_to_ignore . ")>/", $content,
// $matches ) )  {
//                    $ignore_block_element = $matches[1];
//                }
//
//                // If it"s not a tag and not in ignore block
//                if ( "" ==  $ignore_block_element && strlen( $content ) > 0 && "<" != $content[0] ) {
//                    // $content = preg_replace_callback( $wp_smiliessearch, "translate_smiley", $content );
//                }
//
//                // did we exit ignore block
//                if ( "" != $ignore_block_element && "</" . $ignore_block_element . ">" == $content )  {
//                    $ignore_block_element = "";
//                }
//
//                $output .= $content;
//            }
//        } else {
//            // return default text.
//            $output = $text;
//        }
//        return $output;
//    }
//
//    /*
//     * adapted from https://developer.wordpress.org/reference/public statics/current_time/
//     */
//    public static current_myTime( $type, $gmt = 0 ) {
//        switch ( $type ) {
//            case "mysql":
//                return ( $gmt ) ? myGmDate( "Y-m-d H:i:s" , myTime()) : myGmDate( "Y-m-d H:i:s",
// ( myTime() + ( get_option( "gmt_offset" ) * 60 * 60 ) ) );
//            case "myTimestamp":
//                return ( $gmt ) ? myTime() : myTime() + ( get_option( "gmt_offset" ) * 60 * 60 );
//            default:
//                return ( $gmt ) ? myDate( $type , myTime()) : myDate( $type, myTime() + ( get_option( "gmt_offset"
// ) * 60 * 60 ) );
//        }
//    }
//
////38 ------------
//
//    /***************** A* implementation, **********
//     * found here http://granularreverb.com/a_star.php
//     * And slightly adapted (by-ref is not yet supported) - some variables were forward reference usages and other
// bugs
//     */
//
//// A* algorithm by aaz, found at
//// http://althenia.net/svn/stackoverflow/a-star.php?rev=7
//// Binary min-heap with element values stored separately
//
////original code: public static heap_float(&$heap, &$values, $i, $index) {
//    public static heap_float($heap, $values, $i, $index) {
//        $j = 0;
//        for (; $i; $i = $j) {
//            $j = ($i + $i%2)/2 - 1;
//            if ($values[$heap[$j]] < $values[$index])
//                break;
//            $heap[$i] = $heap[$j];
//        }
//        $heap[$i] = $index;
//        return null;
//    }
//
//    //original code: public static heap_push(&$heap, &$values, $index) {
//    public static heap_push($heap, $values, $index) {
//        heap_float($heap, $values, myCount($heap), $index);
//        return null;
//    }
//
//    //original code: public static heap_raise(&$heap, &$values, $index) {
//    public static heap_raise($heap, $values, $index) {
//        heap_float($heap, $values, myArraySearch($index, $heap), $index);
//        return null;
//    }
//
//    //original code: public static heap_pop(&$heap, &$values) {
//    public static heap_pop($heap, $values) {
//        $front = $heap[0];
//        $index = myArrayPop($heap);
//        $n = myCount($heap);
//        if ($n) {
//            $j = 0;
//            for ($i = 0;; $i = $j) {
//                $j = $i*2 + 1;
//                if ($j >= $n)
//                    break;
//                if ($j+1 < $n && $values[$heap[$j+1]] < $values[$heap[$j]])
//                    ++$j;
//                if ($values[$index] < $values[$heap[$j]])
//                    break;
//                $heap[$i] = $heap[$j];
//            }
//            $heap[$i] = $index;
//        }
//        return $front;
//    }
//
//
//// A-star algorithm:
////   $start, $target - node indexes
////   $neighbors($i)     - map of neighbor index => step cost
////   $heuristic($i, $j) - minimum cost between $i and $j
//
//    public static a_star($start, $target, $map) {
//        $open_heap = array($start); // binary min-heap of indexes with values in $f
//        $open      = array($start => TRUE); // set of indexes
//        $closed    = array();               // set of indexes
//
//        $g = [];
//        $h = [];
//        $f = [];
//        $from = [];
//
//        $g[$start] = 0;
//        $h[$start] = heuristic($start, $target);
//        $f[$start] = $g[$start] + $h[$start];
//
//        while ($open) {
//            $i = heap_pop($open_heap, $f);
//            //not yet supported
//            //unset($open[$i]);
//            $open[$i] = null;
//            $closed[$i] = TRUE;
//
//            if ($i == $target) {
//                $path = array();
//                for (; $i != $start; $i = $from[$i])
//                    $path[myCount($path)] = $i;
//                return myArrayReverse($path);
//            }
//
//            foreach (neighbors($i, $map) as $j => $step)
//            if (!myArrayKeyExists($j, $closed))
//                if (!myArrayKeyExists($j, $open) || $g[$i] + $step < $g[$j]) {
//                    $g[$j] = $g[$i] + $step;
//                    $h[$j] = heuristic($j, $target);
//                    $f[$j] = $g[$j] + $h[$j];
//                    $from[$j] = $i;
//
//                    if (!myArrayKeyExists($j, $open)) {
//                        $open[$j] = TRUE;
//                        heap_push($open_heap, $f, $j);
//                    } else
//                        heap_raise($open_heap, $f, $j);
//                }
//        }
//
//        return FALSE;
//    }
//
//
//    const NODE_WIDTH = 51;
//    const NODE_HEIGHT = 23;
//
//    public static a_star_test(){
//        $map = myArrayFill(0, NODE_HEIGHT, myStrRepeat("A", NODE_WIDTH));
//        generate(node(myRand(1, (NODE_WIDTH +NODE_WIDTH %2)/2-1)*2-1,
//                myRand(1, (NODE_HEIGHT+NODE_HEIGHT%2)/2-1)*2-1), $map);
//
//        $start  = node(1, 1);
//        $target = node(NODE_WIDTH+NODE_WIDTH%2-3, NODE_HEIGHT+NODE_HEIGHT%2-3);
//
//        $path = a_star($start, $target, $map);
//
//        myArrayUnshift($path, $start);
//        foreach ($path as $i) {
//            $arr = coord($i);
//            $map[$arr[0]][$arr[1]] = "*";
//        }
//        return null;
//    }
//
//
//    public static node($x, $y) {
//        return $y * NODE_WIDTH + $x;
//    }
//
//    public static coord($i) {
//        $x = $i % NODE_WIDTH;
//        $y = ($i - $x) / NODE_WIDTH;
//        return array($x, $y);
//    }
//
//    public static neighbors($i, $map) {
//        $arr = coord($i);
//        $x = $arr[0];
//        $y = $arr[1];
//        $neighbors = array();
//        if ($x-1 >= 0      && $map[$y][$x-1] == " ") $neighbors[node($x-1, $y)] = 1;
//        if ($x+1 < NODE_WIDTH  && $map[$y][$x+1] == " ") $neighbors[node($x+1, $y)] = 1;
//        if ($y-1 >= 0      && $map[$y-1][$x] == " ") $neighbors[node($x, $y-1)] = 1;
//        if ($y+1 < NODE_HEIGHT && $map[$y+1][$x] == " ") $neighbors[node($x, $y+1)] = 1;
//        return $neighbors;
//    }
//
//    public static heuristic($i, $j) {
//        $arr_i = coord($i);
//        $arr_j = coord($j);
//        return abs($arr_i[0] - $arr_j[0]) + abs($arr_i[1] - $arr_j[1]);
//    }
//
//    public static generate($i, $map) {
//        $arr = coord($i);
//        $x = $arr[0];
//        $y = $arr[1];
//        $map[$x][$y] = " ";
//        $next = array();
//        if ($x-2 > 0)         $next[myCount($next)] = array(-2, 0);
//        if ($x+2 < NODE_WIDTH-1)  $next[myCount($next)] = array(+2, 0);
//        if ($y-2 > 0)         $next[myCount($next)] = array(0, -2);
//        if ($y+2 < NODE_HEIGHT-1) $next[myCount($next)] = array(0, +2);
//        myShuffle($next);
//        foreach ($next as $d)
//        if ($map[$y+$d[1]  ][$x+$d[0]  ] != " ") {
//            $map[$y+$d[1]/2][$x+$d[0]/2]  = " ";
//            generate(node($x+$d[0], $y+$d[1]));
//        }
//        return null;
//    }
//
//    public static display_maze($map) {
//        foreach ($map as $line) {
//            echo str_replace("A","<span></span>",str_replace("*","<img src="google_smile.gif" width="12"
// height="12">",$line))."\n";
//        }
//        return null;
//    }
//
//// 50 -----------------------
//
//    /***********   start test public statics ***************/
//
//    public static megamorphicAdd(
//            $a1,  $a2,  $a3,  $a4,  $a5,
//            $a6,  $a7,  $a8,  $a9,  $a10,
//            $a11, $a12, $a13, $a14, $a15,
//            $a16, $a17, $a18, $a19, $a20) {
//
//        return $a1  + $a2  + $a3  + $a4  + $a5
//                + $a6  + $a7  + $a8  + $a9  + $a10
//                + $a11 + $a12 + $a13 + $a14 + $a15
//                + $a16 + $a17 + $a18 + $a19 + $a20;
//    }
//
//    public static endless(){
//        return endless();
//    }
//
//    //direct recursive public statics and soft typing
//    public static test(array $a){
//        $a = $a > 1 ? test($a - 1) : 0; return $a;
//    }
//
//    //parametric polymorphic direct recursive public static
//    public static fibGen($n){
//        return $n > 0 ? fibGen($n-1) + fibGen($n-2) : $n;
//    }
//
//    public static add($x, $y) {
//        return $x + $y;
//    }
//
//    public static fib($n) {
//        return $n > 0 ? fib($n - 1) + fib($n - 2) : 1;
//    }
//
//    public static fac($n) {
//        return $n > 0 ? $n * fac($n) : $n;
//    }
//
//    public static startsWith($text, $value) {
//        return myStrPos($text, $value) === 0;
//    }
//
//    public static withImplicitReturn($x) {
//        if ($x) {
//            return $x + 1;
//        }
//    }
//
//    public static wrapIt($value, $wrapIt) {
//        if ($wrapIt) {
//            return [$value];
//        }
//        return $value;
//    }
//
//// 10 (total 60) -------------------------------
//
//    /* Fallback to soft typing required */
//    public static addOne($x) {
//        if (myIsArray($x)) {
//            return $x + [1];
//        }
//        return $x + 1;
//    }
//
//    public static typeHintAndDataPolymorphism(array $x, $key) {
//        $x = $x[$key];
//        return $x + 1;
//    }
//
//    public static identity($x) {
//        return $x;
//    }
//
//    public static convertibleToString($x) {
//        echo $x;
//        return identity($x);
//    }
//
//    public static asStringReturnString($x) {
//        echo $x;
//        return (string) $x;
//    }
//
//    public static countValue(array $arr, $value) {
//        $count = 0;
//        for ($i = 0; $i < myCount($arr); ++$i) {
//            if ($arr[$i] == $value) {
//                ++$count;
//            }
//        }
//        return $count;
//    }
//
//    public static isEven($x) {
//        return $x % 2 == 0;
//    }
//
//    public static isOdd($x) {
//        return $x % 2 == 1;
//    }
//
//    public static someLogic($x, $y, $z) {
//        $a = $x || $y && !$z;
//        $b = !$x or $y xor $z and $a;
//        return $a == $b;
//    }
//
//    public static orExit($x) {
//        $x or exit(-1);
//        return null;
//    }
//
////20 (total 70)-------------------------------
//
//    public static andExit($x) {
//        $x and exit(0);
//        return null;
//    }
//
//
//    public static bitwise1($x, $y, $z) {
//        return $x & $y | $z;
//    }
//
//    public static bitwise2($x, $y, $z) {
//        return $x << 2 & ($y >> 1) ^ $z;
//    }
//
//    public static arithmetic1($x, $y, $z) {
//        return ($x + $y) * $z / 2;
//    }
//
//    public static arithmetic2($x, $y, $z) {
//        return abs(+($x / -$y) % $z);
//    }
//
//    public static array1($x, $y) {
//        $x[0] = $y;
//        return $x;
//    }
//
//    public static array2(array $x, $y) {
//        $x + $y;
//        return $x[3];
//    }
//
////30 (total 80) ------------------------------
//
//    public static combi1($x, $y, $z){
//        $a = myTruncate($x, 12, 10, $z);
//        $email = encode_email($a, "blabla", 123);
//        show_gravatar($email, $y, "pic", "good");
//        return $a;
//    }
//
//    public static combi2($x, $y, $z){
//        $a = myAddCSlashes($x, "a..z");
//        $b = str_replace($a, $y, $z);
//        return myHtmlEntities($a);
//    }
//
//    public static combi3($x){
//        $password1 = generate_rand(12);
//        $password2 = readable_random_string($_GET["number"]);
//        return myArrayMerge([$password1], [$password2]);
//    }
//
//    public static combi4($x, $y, $z){
//        $a = isEven($x);
//        $b = isOdd($y);
//        return someLogic($a, $b, $z);;
//    }
//
//    public static combi5($x, $y, $z){
//        $a = combi1($x, "a", "b");
//        $b = combi2($y, "c", "d");
//        $c = combi3($z, "a", "b");
//        return combi5($a, $b, $c);
//    }
//
//    public static combi6($x, $y, $z){
//        return bitwise1($x, bitwise2(1, $y, 3), 4);
//    }
//
//    public static combi7($x, $y, $z){
//        if($x > 10){
//            return arithmetic1(1.2, $y, abs(1)) / $z;
//        }
//        return false;
//    }
//
//    public static combi8($x, $y){
//        $a = eo_php2xdate($y);
//        myArrayPush($y, $a);
//        return fnbx_html_tag($y);
//    }
//
//    public static combi9($x, $y){
//        $a = myOrd($x) + myOrd($y);
//        $b = myParseUrl("result is: ".$a);
//        return asStringReturnString(myTrim($b));
//    }
//
//    public static combi10($w, $x, $y, $z){
//        $a = countValue($x, $y);
//        $b = myArrayMerge($x, $z);
//        myArrayPush($b, 12);
//        $c = countValue($b, $y);
//        return ($a - $c) / $w;
//    }
//
////40 (total 90) -------------------
//
//    /********** start indirect recursive public statics ******************/
//
//    public static foo8($x){
//        if($x > 0){
//            return bar8($x-1);
//        }
//        return $x;
//    }
//
//    public static bar8($x){
//        if($x > 0){
//            return foo8($x-1);
//        }
//        return $x;
//    }
//
//    // indirect recursive public static with parameter which has no constraint other than recursive public static,
//// hence will not have a binding during the first iteration
//    public static foo9($x) {
//        return bar9($x);
//    }
//
//    public static bar9($x){
//        if($x > 0){
//            return foo9($x-1);
//        }
//        return $x;
//    }
//
//    // indirect recursive public static which does not change during first iteration,
//// dependent public static changes though
//    public static foo10($x){
//        return foo10B($x);
//    }
//
//    public static foo10B($x){
//        return bar10($x);
//    }
//
//    public static bar10($x){
//        if($x > 0){
//            return foo10($x-1);
//        }
//        return $x;
//    }
//
//    //
//    public static foo11($x, $y){
//        return $x > 0 ?  bar11($x & $y, $y) : $x;
//    }
//
//    public static bar11($x, $y){
//        return $x > 10 ? foo11($x - $y, $y) : $y;
//    }
//
//    //
//    public static foo1($x, $y){
//        return bar1($x, $y);
//    }
//
//    public static bar1($x, $y){
//        return $x > 10 ? foo1($x - $y, $y) : $y;
//    }
//
//    //
//    public static foo14($x, $y){
//        return $x > 0 ?  bar14($x + $y, $y) : $x;
//    }
//
//    public static bar14($x, $y){
//        return $x > 10 ? foo14($x + $y, $y) : $y;
//    }
//
//    //indirect recursive public static which produces more overloads once
////the dependent public static is known.
//    public static foo3($x, $y){
//        return bar3($x, $y);
//    }
//
//    public static bar3($x, $y){
//        return $x > 10 ? foo3($x + $y, $y) : $y;
//    }
//
//    //
//    public static foo($x, $y){
//        if($x){
//            return $y;
//        }
//        return bar($y);
//    }
//
//    public static bar($x){
//        if($x > 0){
//            return foo(false, $x);
//        }
//        return $x;
//    }
//
//    //
//    public static foo17($x, $y){
//        return bar17($x, $y);
//    }
//
//    public static bar17($x, $y){
//        return $x > 10 ? foo17($x + $y, $y) : $y;
//    }
//
//    //
//    public static foo17B($x, $y){
//        return bar17B($x, $y);
//    }
//
//    public static bar17B($x, $y){
//        return $x > 10 ? foo17B($x, $x + $y) : $y;
//    }
//
//
////10 ---------------------------- indirect recursive public static groups
//
//    ?>

    //some additional helper dummy methods;

    private static int asInt(Object o) {
        if (o instanceof Integer) {
            return (Integer) o;
        } else if (o instanceof Boolean) {
            return ((Boolean) o) ? 1 : 0;
        } else if (o instanceof Double) {
            return ((Double) o).intValue();
        } else if (o instanceof String) {
            return Integer.parseInt((String) o);
        } else {
            return 1;
        }
    }

    private static double asDouble(Object o) {
        if (o instanceof Double) {
            return (Double) o;
        } else if (o instanceof Boolean) {
            return ((Boolean) o) ? 1 : 0;
        } else if (o instanceof Integer) {
            return (Integer) o;
        } else if (o instanceof String) {
            return Double.parseDouble((String) o);
        } else {
            return 1;
        }
    }

    private static boolean asBool(Object o) {
        if (o instanceof Integer) {
            return ((Integer) o) != 0;
        } else if (o instanceof Double) {
            return ((Double) o) != 0.0;
        } else if (o instanceof String) {
            return !((String) o).isEmpty();
        } else {
            return o != null;
        }
    }

    private static Object mod(Object a, Object b) {
        int c = asInt(b);
        if (c != 0) {
            return asInt(a) % c;
        }
        return false;
    }

    private static Number oldSchoolAddition(Object $left, Object $right) {
        //only a dummy implementation
        if ($left instanceof Integer && $right instanceof Integer) {
            return (Integer) $left + (Integer) $right;
        } else if ($left instanceof Double && $right instanceof Double) {
            return (Double) $left + (Double) $right;
        } else {
            return asDouble($left) + asDouble($right);
        }
    }

    private static Number oldSchoolSubtraction(Object $left, Object $right) {
        //only a dummy implementation
        if ($left instanceof Integer && $right instanceof Integer) {
            return (Integer) $left - (Integer) $right;
        } else if ($left instanceof Double && $right instanceof Double) {
            return (Double) $left - (Double) $right;
        } else {
            return asDouble($left) - asDouble($right);
        }
    }

    private static Object oldSchoolMultiply(Object $left, Object $right) {
        //only a dummy implementation
        if ($left instanceof Integer && $right instanceof Integer) {
            return (Integer) $left * (Integer) $right;
        } else if ($left instanceof Double && $right instanceof Double) {
            return (Double) $left * (Double) $right;
        } else {
            return asDouble($left) * asDouble($right);
        }
    }

    public static Object oldSchoolIntDivide(int $left, int $right) {
        if ($right == 0) {
            return false;
        }
        if ($left % $right != 0) {
            return (double) $left / $right;
        }
        return $left / $right;
    }

    private static Object oldSchoolDivide(Object $left, Object $right) {
        //only a dummy implementation
        if ($left instanceof Integer && $right instanceof Integer) {
            return oldSchoolIntDivide((Integer) $left, (Integer) $right);
        } else if ($left instanceof Double && $right instanceof Double) {
            if ((Double) $right != 0) {
                return (Double) $left / (Double) $right;
            } else {
                return false;
            }
        } else {
            if (asDouble($right) != 0) {
                return asDouble($left) + asDouble($right);
            } else {
                return false;
            }
        }
    }

    private static <T> T oldSchoolIncrement(T o) {
        return o;
    }

}
