import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "UnusedDeclaration"})
public class Test0
{

    public static void main(String[] args) {
        System.out.println(null instanceof Object);

    }

    //------------------

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

    public static Map myArraySlice(Map $array, Object $offset, Object $length) {
        mod($offset, $length);
        return new HashMap();
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

    public static boolean myEmpty(Object $var) {
        return false;
    }


    public static boolean myInArray(Object $needle, Map $haystack) {
        return false;
    }

    public static boolean myIsset(Object $var) {
        return true;
    }

    public static Double myLog(Object $arg, Object $basis) {
        mod($basis, 20);
        if (asBool(floor($arg))) {
            return 1.2;
        }
        return null;
    }

    private static Object str_replace(Object $pattern, Object $replacement, Object $subject) {
        //only a dummy
        return String.valueOf($pattern).replace(String.valueOf($replacement), String.valueOf($subject));
    }


    public static Object myRound(Object $val, Object $precision) {
        mod($precision, 20);
        return floor($val);
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

    public static Object myStrSplit(Object $string, Object $split_length) {
        String s = String.valueOf($string) + "1";
        if (asBool(mod($split_length, 20))) {
            return new HashMap();
        }
        return false;
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
        Object $separator = $arr.get(floor(oldSchoolDivision(oldSchoolAddition($left, $right), 2)));

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
            $d.put($i, oldSchoolAddition(oldSchoolMultiplication(2, $d.get($i - 1)), 1));
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

        Object $mid = oldSchoolDivision(oldSchoolAddition($left, $right), 2);

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
            Object $mid = oldSchoolDivision(oldSchoolAddition($left, $right), 2);

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

    public static Object term_exists(Object $term, Object $taxonomy, Object $parent) {
        String s = String.valueOf($term) + "a";
        if (asBool(mod($parent, 20))) {
            return "id";
        } else if ((String.valueOf($taxonomy) + "a" + String.valueOf($term) + "$a").equals("banana")) {
            Map a = new HashMap();
            a.put(0, "term1");
            a.put(1, "term2");
            return a;
        }
        return null;
    }

//18 ------------


    /**
     * ********   start test public statics **************
     */

    public static <T extends Number> T megamorphicAdd(
            Object $a1, Object $a2, Object $a3, Object $a4, Object $a5,
            Object $a6, Object $a7, Object $a8, Object $a9, Object $a10,
            Object $a11, Object $a12, Object $a13, Object $a14, Object $a15,
            Object $a16, Object $a17, Object $a18, Object $a19, Object $a20) {

        return (T) (oldSchoolAddition((T) (oldSchoolAddition((T) (oldSchoolAddition((T) (oldSchoolAddition((T)
                (oldSchoolAddition((T) (oldSchoolAddition((T) (oldSchoolAddition((T) (oldSchoolAddition((T)
                        (oldSchoolAddition((T) (oldSchoolAddition((T) (oldSchoolAddition((T) (oldSchoolAddition((T)
                                        (oldSchoolAddition((T) (oldSchoolAddition((T) (oldSchoolAddition((T)
                                                        (oldSchoolAddition((T) (oldSchoolAddition((T)
                                                                        (oldSchoolAddition(
                                                                                (T) (oldSchoolAddition($a1, $a2)),
                                                                                $a3)),
                                                                $a4)), $a5)),
                                                $a6)), $a7)), $a8)), $a9)), $a10)), $a11)),
                                $a12)), $a13)), $a14)), $a15)), $a16)), $a17)), $a18)), $a19)), $a20));
    }

    //direct recursive public statics and soft typing
    public static Object test(Object $a_0) {
        Object $a = $a_0;
        $a = ((Comparable) $a).compareTo(1) > 0 ? test(oldSchoolSubtraction($a, 1)) : 0;
        return $a;
    }

    //parametric polymorphic direct recursive public static
    public static Object fibGen(Object $n) {
        return ((Comparable) $n).compareTo(0) > 0
                ? oldSchoolAddition(fibGen(oldSchoolSubtraction($n, 1)), fibGen(oldSchoolSubtraction($n, 2)))
                : $n;
    }

    public static Number withImplicitReturn(Object $x) {
        if (asBool($x)) {
            return oldSchoolAddition($x, 1);
        }
        return null;
    }

    public static Number typeHintAndDataPolymorphism(Map $x_0, Object $key) {
        Object $x = $x_0.get($key);
        return oldSchoolAddition($x, 1);
    }

    public static int countValue(Map $arr, Object $value) {
        int $count = 0;
        for (int $i = 0; $i < myCount($arr); ++$i) {
            if ($arr.get($i) == $value) {
                ++$count;
            }
        }
        return $count;
    }

    private static boolean or(boolean $x, boolean $y) {
        return true;
    }

    private static boolean xor(boolean b, boolean $a) {
        return true;
    }

    private static boolean and(boolean b, boolean $a) {
        return true;
    }

    public static boolean someLogic(Object $x, Object $y, Object $z) {
        boolean $a = asBool($x) || asBool($y) && !asBool($z);
        boolean $b;
        or($b = !asBool($x), xor(asBool($y), and(asBool($z), $a)));
        return $a == $b;
    }

    /********** start indirect recursive public statics ******************/

    public static Object foo8(Object $x){
        if(((Comparable)$x).compareTo(0) > 0){
            return bar8(oldSchoolSubtraction($x, 1));
        }
        return $x;
    }

    public static Object bar8(Object $x){
        if(((Comparable)$x).compareTo(0) > 0){
            return foo8(oldSchoolSubtraction($x, 1));
        }
        return $x;
    }

    // indirect recursive public static with parameter which has no constraint other than recursive public static,
// hence will not have a binding during the first iteration
    public static Object foo9(Object $x) {
        return bar9($x);
    }

    public static Object bar9(Object $x){
        if(((Comparable)$x).compareTo(0) > 0){
            return foo9(oldSchoolSubtraction($x, 1));
        }
        return $x;
    }

//10 ---------------------------- indirect recursive public static groups


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

    private static Number oldSchoolMultiplication(Object $left, Object $right) {
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

    private static Object oldSchoolDivision(Object $left, Object $right) {
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

    private static Object oldSchoolBitwiseOr(Object $left, Object $right) {
        //only a dummy implementation
        if ($left instanceof Integer && $right instanceof Integer) {
            return (Integer) $left | (Integer) $right;
        } else if ($left instanceof Double && $right instanceof Double) {
            return ((Double) $left).intValue() | ((Double) $right).intValue();
        } else if ($left instanceof String && $right instanceof String) {
            return (String) $left + (String) $right;
        }
        return asInt($left) | asInt($right);
    }

    private static Object oldSchoolBitwiseXor(Object $left, Object $right) {
        //only a dummy implementation
        if ($left instanceof Integer && $right instanceof Integer) {
            return (Integer) $left ^ (Integer) $right;
        } else if ($left instanceof Double && $right instanceof Double) {
            return ((Double) $left).intValue() ^ ((Double) $right).intValue();
        } else if ($left instanceof String && $right instanceof String) {
            return (String) $left + (String) $right;
        }
        return asInt($left) ^ asInt($right);
    }

    private static Object oldSchoolBitwiseAnd(Object $left, Object $right) {
        //only a dummy implementation
        if ($left instanceof Integer && $right instanceof Integer) {
            return (Integer) $left & (Integer) $right;
        } else if ($left instanceof Double && $right instanceof Double) {
            return ((Double) $left).intValue() & ((Double) $right).intValue();
        } else if ($left instanceof String && $right instanceof String) {
            return (String) $left + (String) $right;
        }
        return asInt($left) & asInt($right);
    }

    private static <T> T oldSchoolIncrement(T o) {
        return o;
    }

}
