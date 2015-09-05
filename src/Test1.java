import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "UnusedDeclaration"})
public class Test1
{

    public static void main(String[] args) {
        System.out.println(null instanceof Object);

    }

    //------------------

    public static boolean myArrayKeyExists(Object $key, Map $array) {
        return true;
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

    public static boolean myIsArray(Object $var) {
        return true;
    }

    public static Double myLog(Object $arg, Object $basis) {
        mod($basis, 20);
        if (asBool(floor($arg))) {
            return 1.2;
        }
        return null;
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

    public static Object myRound(Object $val, Object $precision) {
        mod($precision, 20);
        return floor($val);
    }


    public static boolean myShuffle(Map $array) {
        return true;
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

    public static <T> T get_option(T $option) {
        return $option;
    }

    /*
     * https://developer.wordpress.org/reference/public statics/balancetags/
     */
    public static Object balanceTags(Object $text, Object $force) {
        if (asBool($force) || asInt(get_option("use_balanceTags")) == 1) {
            return force_balance_tags($text);
        } else {
            return $text;
        }
    }

    /*
     * adapted from https://developer.wordpress.org/reference/public statics/backslashit/
     */
    public static Object force_balance_tags(Object $text) {
        Map $tagstack = new HashMap();
        int $stacksize = 0;
        String $tagqueue = "";
        Object $newtext = "";
        // Known single-entity/self-closing tags
        Map $single_tags = new HashMap();
        $single_tags.put(0, "area");
        $single_tags.put(1, "base");
        $single_tags.put(2, "basefont");
        $single_tags.put(3, "br");
        $single_tags.put(4, "col");
        $single_tags.put(5, "command");
        $single_tags.put(6, "embed");
        $single_tags.put(7, "frame");
        $single_tags.put(8, "hr");
        $single_tags.put(9, "img");
        $single_tags.put(10, "input");
        $single_tags.put(11, "isindex");
        $single_tags.put(12, "link");
        $single_tags.put(13, "meta");
        $single_tags.put(14, "param");
        $single_tags.put(15, "source");
        // Tags that can be immediately nested within themselves
        Map $nestable_tags = new HashMap();
        $nestable_tags.put(0, "blockquote");
        $nestable_tags.put(1, "div");
        $nestable_tags.put(2, "object");
        $nestable_tags.put(3, "q");
        $nestable_tags.put(4, "span");

        // WP bug fix for comments - in case you REALLY meant to type "< !--"
        $text = str_replace("< !--", "<    !--", $text);
        // WP bug fix for LOVE <3 (and other situations with "<" before a number)
        $text = myPregReplace("#<([0-9]{1})#", "&lt;$1", $text);

        Map $regex = new HashMap();
        while (asBool(myPregMatch("/<(\\/?[\\w:]*)\\s*([^>]*)>/", $text, $regex))) {
            $newtext = String.valueOf($newtext) + $tagqueue;

            Object $i = myStrPos($text, $regex.get(0));
            int $l = myStrLen($regex.get(0));

            // clear the shifter
            $tagqueue = "";
            // Pop or Push
            String $tag;
            if (myIsset(((Map) $regex.get(1)).get(0)) && "/" == ((Map) $regex.get(1)).get(0)) { // End Tag
                $tag = myStrToLower(mySubstr2($regex.get(1), 1));
                // if too many closing tags
                if ($stacksize <= 0) {
                    $tag = "";
                    // or close to be safe $tag = "/" . $tag;
                }
                // if stacktop value = tag close value then pop
                else if ($tagstack.get($stacksize - 1) == $tag) { // found closing tag
                    $tag = "</" + $tag + ">"; // Close Tag
                    // Pop
                    myArrayPop($tagstack);
                    $stacksize--;
                } else { // closing tag not at top, search for it
                    for (int $j = $stacksize - 1; $j >= 0; $j--) {
                        if ($tagstack.get($j) == $tag) {
                            // add tag to tagqueue
                            for (int $k = $stacksize - 1; $k >= $j; $k--) {
                                $tagqueue += "</" + String.valueOf(myArrayPop($tagstack)) + ">";
                                $stacksize--;
                            }
                            break;
                        }
                    }
                    $tag = "";
                }
            } else { // Begin Tag
                $tag = myStrToLower($regex.get(1));

                // Tag Cleaning

                // If it"s an empty tag "< >", do nothing
                if ("" == $tag) {
                    // do nothing
                }
                // ElseIf it presents itself as a self-closing tag...
                else if (mySubstr2($regex.get(2), -1) == "/") {
                    // ...but it isn"t a known single-entity self-closing tag, then don"t let it be treated as such and
                    // immediately close it with a closing tag (the tag will encapsulate no text as a result)
                    if (!myInArray($tag, $single_tags)) {
                        $regex.put(2, myTrim(mySubstr($regex.get(2), 0, -1)) + "></" + $tag);
                    }
                }
                // ElseIf it"s a known single-entity tag but it doesn"t close itself, do so
                else if (myInArray($tag, $single_tags)) {
                    $regex.put(2, "/");
                }
                // Else it"s not a single-entity tag
                else {
                    // If the top of the stack is the same as the tag we want to push, close previous tag
                    if ($stacksize > 0 && !myInArray($tag, $nestable_tags) && $tagstack.get($stacksize - 1) == $tag) {
                        $tagqueue = "</" + String.valueOf(myArrayPop($tagstack)) + ">";
                        $stacksize--;
                    }
                    $stacksize = myArrayPush($tagstack, $tag);
                }

                // Attributes
                Object $attributes = $regex.get(2);
                if (!myEmpty($attributes) && ((Map) $attributes).get(0) != ">") {
                    $attributes = " " + $attributes;
                }

                $tag = "<" + $tag + String.valueOf($attributes) + ">";
                //If already queuing a close tag, then put this tag on, too
                if (!myEmpty($tagqueue)) {
                    $tagqueue += $tag;
                    $tag = "";
                }
            }
            $newtext = String.valueOf($newtext) + String.valueOf(mySubstr($text, 0, $i)) + $tag;
            $text = mySubstr2($text, oldSchoolAddition($i, $l));
        }

        // Clear Tag Queue
        $newtext = String.valueOf($newtext) + $tagqueue;

        // Add Remaining text
        $newtext = String.valueOf($newtext) + $text;

        // Empty Stack
        Object $x;
        while (asBool($x = myArrayPop($tagstack))) {
            $newtext = String.valueOf($newtext) + "</" + String.valueOf($x) + ">"; // Add remaining tags to close
        }

        // WP fix for the bug with HTML comments
        $newtext = str_replace("< !--", "<!--", $newtext);
        $newtext = str_replace("<    !--", "< !--", $newtext);

        return $newtext;
    }

    //20 ----------------------------


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

    /*
     * adapted from https://developer.wordpress.org/reference/public statics/category_exists/
     */
    public static Object category_exists(Object $cat_name, Object $parent) {
        Object $id = term_exists($cat_name, "category", $parent);
        if (myIsArray($id)) {
            $id = ((Map) $id).get("term_id");
        }
        return $id;
    }

    /*
     * copied from https://developer.wordpress.org/reference/public statics/convert_invalid_entities/
     */
    public static Object convert_invalid_entities(Object $content) {
        Map $wp_htmltranswinuni = new HashMap();
        $wp_htmltranswinuni.put("&#128;", "&#8364;"); // the Euro sign
        //...

        if (((Comparable) myStrPos($content, "&#1")).compareTo(false) == 0) {
            $content = myStrtr($content, $wp_htmltranswinuni);
        }

        return $content;
    }

//22 ------------

    /**
     * ************** A* implementation, **********
     * found here http://granularreverb.com/a_star.php
     * And slightly adapted (by-ref is not yet supported) - some variables were forward reference usages and other
     * bugs
     */

// A* algorithm by aaz, found at
// http://althenia.net/svn/stackoverflow/a-star.php?rev=7
// Binary min-heap with element values stored separately

//original code: public static heap_float(&$heap, &$values, $i, $index) {
    public static Void heap_float(Map $heap, Map $values, Object $i, Object $index) {
        Number $j = 0;
        for (; asBool($i); $i = $j) {
            $j = oldSchoolSubtraction(oldSchoolDivision(oldSchoolAddition($i, asInt($i) % 2), 2), 1);
            if (((Comparable) $values.get($heap.get($j))).compareTo($values.get($index)) < 0) {
                break;
            }
            $heap.put($i, $heap.get($j));
        }
        $heap.put($i, $index);
        return null;
    }

    //original code: public static heap_push(&$heap, &$values, $index) {
    public static Void heap_push(Map $heap, Map $values, Object $index) {
        heap_float($heap, $values, myCount($heap), $index);
        return null;
    }

    //original code: public static heap_raise(&$heap, &$values, $index) {
    public static Void heap_raise(Map $heap, Map $values, Object $index) {
        heap_float($heap, $values, myArraySearch($index, $heap), $index);
        return null;
    }

    //original code: public static heap_pop(&$heap, &$values) {
    public static Object heap_pop(Map $heap, Map $values) {
        Object $front = $heap.get(0);
        Object $index = myArrayPop($heap);
        int $n = myCount($heap);
        int $i;
        if (asBool($n)) {
            int $j = 0;
            for ($i = 0; ; $i = $j) {
                $j = $i * 2 + 1;
                if (((Comparable) $j).compareTo($n) >= 0) {
                    break;
                }
                if ($j + 1 < $n
                        && ((Comparable) $values.get($heap.get($j + 1))).compareTo($values.get($heap.get($j))) < 0) {
                    ++$j;
                }
                if (((Comparable) $values.get($index)).compareTo($values.get($heap.get($j))) < 0) {
                    break;
                }
                $heap.put($i, $heap.get($j));
            }
            $heap.put($i, $index);
        }
        return $front;
    }


// A-star algorithm:
//   $start, $target - node indexes
//   $neighbors($i)     - map of neighbor index => step cost
//   $heuristic($i, $j) - minimum cost between $i and $j

    public static Object a_star(Object $start, Object $target, Map $map) {
        Map $open_heap = new HashMap();
        $open_heap.put(0, $start);       // binary min-heap of indexes with values in $f
        Map $open = new HashMap();
        $open.put($start, true);        // set of indexes
        Map $closed = new HashMap();    // set of indexes

        Map $g = new HashMap();
        Map $h = new HashMap();
        Map $f = new HashMap();
        Map $from = new HashMap();

        $g.put($start, 0);
        $h.put($start, heuristic($start, $target));
        $f.put($start, oldSchoolAddition($g.get($start), $h.get($start)));

        while (asBool($open)) {
            Object $i = heap_pop($open_heap, $f);
            //not yet supported
            //unset($open[$i]);
            $open.put($i, null);
            $closed.put($i, true);

            if ($i == $target) {
                Map $path = new HashMap();
                for (; $i != $start; $i = $from.get($i)) {
                    $path.put(myCount($path), $i);
                }
                return myArrayReverse($path);
            }

            Set<Map.Entry> set = neighbors($i, $map).entrySet();
            for (Map.Entry entry : set) {
                Object $j = entry.getKey();
                Object $step = entry.getValue();

                if (!myArrayKeyExists($j, $closed)) {
                    if (!myArrayKeyExists($j, $open)
                            || ((Comparable) oldSchoolAddition($g.get($i), $step)).compareTo($g.get($j)) < 0) {
                        $g.put($j, oldSchoolAddition($g.get($i), $step));
                        $h.put($j, heuristic($j, $target));
                        $f.put($j, oldSchoolAddition($g.get($j), $h.get($j)));
                        $from.put($j, $i);

                        if (!myArrayKeyExists($j, $open)) {
                            $open.put($j, true);
                            heap_push($open_heap, $f, $j);
                        } else {
                            heap_raise($open_heap, $f, $j);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int NODE_WIDTH = 51;
    public static int NODE_HEIGHT = 23;

    public static Number node(Object $x, Object $y) {
        return oldSchoolMultiplication($y, oldSchoolAddition(NODE_WIDTH, $x));
    }

    public static Map coord(Object $i) {
        Object $x = mod($i, NODE_WIDTH);
        Object $y = oldSchoolDivision(oldSchoolSubtraction($i, $x), NODE_WIDTH);
        Map a = new HashMap();
        a.put(0, $x);
        a.put(0, $y);
        return a;
    }

    public static Map neighbors(Object $i, Map $map) {
        Map $arr = coord($i);
        Object $x = $arr.get(0);
        Object $y = $arr.get(1);
        Map $neighbors = new HashMap();
        if (((Comparable) oldSchoolSubtraction($x, 1)).compareTo(0) >= 0
                && ((Map) $map.get($y)).get(oldSchoolSubtraction($x, 1)) == " ") {
            $neighbors.put(node(oldSchoolSubtraction($x, 1), $y), 1);
        }
        if (((Comparable) oldSchoolAddition($x, 1)).compareTo(NODE_WIDTH) < 0 &&
                ((Map) $map.get($y)).get(oldSchoolAddition($x, 1)) == " ") {
            $neighbors.put(node(oldSchoolAddition($x, 1), $y), 1);
        }
        if (((Comparable) oldSchoolSubtraction($y, 1)).compareTo(0) >= 0
                && ((Map) $map.get(oldSchoolSubtraction($y, 1))).get($x) == " ") {
            $neighbors.put(node($x, oldSchoolSubtraction($y, 1)), 1);
        }
        if (((Comparable) oldSchoolAddition($y, 1)).compareTo(NODE_HEIGHT) < 0
                && ((Map) $map.get(oldSchoolAddition($y, 1))).get($x) == " ") {
            $neighbors.put(node($x, oldSchoolAddition($y, 1)), 1);
        }
        return $neighbors;
    }

    public static Number heuristic(Object $i, Object $j) {
        Map $arr_i = coord($i);
        Map $arr_j = coord($j);
        Number numberX = oldSchoolSubtraction($arr_i.get(0), $arr_j.get(0));
        Number numberY = oldSchoolSubtraction($arr_i.get(1), $arr_j.get(1));
        return Math.abs(numberX instanceof Integer ? (Integer) numberX : (Double) numberX) + Math.abs(numberY
                instanceof Integer ? (Integer) numberY : (Double) numberY);
    }

    public static Object generate(Object $i, Map $map) {
        Map $arr = coord($i);
        Object $x = $arr.get(0);
        Object $y = $arr.get(1);
        ((Map) $map.get($x)).put($y, " ");
        Map $next = new HashMap();
        if (((Comparable) oldSchoolSubtraction($x, 2)).compareTo(0) > 0) {
            Map pair = new HashMap();
            pair.put(0, -2);
            pair.put(1, 0);
            $next.put(myCount($next), pair);
        }
        if (((Comparable) oldSchoolAddition($x, 2)).compareTo(NODE_WIDTH - 1) < 0) {
            Map pair = new HashMap();
            pair.put(0, 2);
            pair.put(1, 0);
            $next.put(myCount($next), pair);
        }
        if (((Comparable) oldSchoolSubtraction($y, 2)).compareTo(0) > 0) {
            Map pair = new HashMap();
            pair.put(0, 0);
            pair.put(1, -2);
            $next.put(myCount($next), pair);
        }
        if (((Comparable) oldSchoolAddition($y, 2)).compareTo(NODE_HEIGHT - 1) < 0) {
            Map pair = new HashMap();
            pair.put(0, 0);
            pair.put(1, 2);
            $next.put(myCount($next), pair);
        }
        myShuffle($next);
        for (Object $d : $next.values()) {
            Map element = (Map) $map.get(oldSchoolAddition($y, ((Map) $d).get(1)));
            if (element.get(oldSchoolAddition($x, ((Map) $d).get(0))) != " ") {
                Map element2 = (Map) $map.get(oldSchoolAddition($y, oldSchoolDivision(((Map) $d).get(1), 2)));
                element2.put(oldSchoolAddition($x, oldSchoolDivision(((Map) $d).get(0), 2)), ' ');
                generate(
                        node(oldSchoolAddition($x, ((Map) $d).get(0)), oldSchoolAddition($y, ((Map) $d).get(1))),
                        $map);
            }
        }
        return null;
    }

    public static Void display_maze(Map $map) {
        for (Object $line : $map.values()) {
            System.out.println(str_replace("A", "<span></span>",
                    str_replace("*", "<img src=\"google_smile.gif\" width=\"12\" height=\"12\"> ",
                            String.valueOf($line)) + "\n"));
        }
        return null;
    }

// 50 -----------------------

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

    /* Fallback to soft typing required */
    public static Object addOne(Object $x) {
        if (myIsArray($x)) {
            Map map = new HashMap();
            map.put(0, 1);
            return myArrayMerge((Map) $x, map);
        }
        return oldSchoolAddition($x, 1);
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

    public static Object arithmetic1(Object $x, Object $y, Object $z) {
        return oldSchoolDivision(oldSchoolMultiplication(oldSchoolAddition($x, $y), $z), 2);
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

    // indirect recursive public static which does not change during first iteration,
// dependent public static changes though
    public static Object foo10(Object $x){
        return foo10B($x);
    }

    public static Object foo10B(Object $x){
        return bar10($x);
    }

    public static Object bar10(Object $x){
        if(((Comparable)$x).compareTo(0) > 0){
            return foo10(oldSchoolSubtraction($x, 1));
        }
        return $x;
    }

    //
    public static Object foo11(Object $x, Object $y){
        return ((Comparable)$x).compareTo(0) > 0 ?  bar11(oldSchoolBitwiseAnd($x, $y), $y) : $x;
    }

    public static Object bar11(Object $x, Object $y){
        return ((Comparable)$x).compareTo(10) >0 ? foo11(oldSchoolSubtraction($x ,$y), $y) : $y;
    }

    //
    public static Object foo1(Object $x,Object $y){
        return bar1($x, $y);
    }

    public static Object bar1(Object $x,Object $y){
        return ((Comparable)$x).compareTo(10) > 0 ? foo1(oldSchoolSubtraction($x, $y), $y) : $y;
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
