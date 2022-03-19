public class HtmlFormat {

    public static String header(String str, int size) {
        return String.format("<h%d>%s</h%d>%n", size, str, size);
    }
    public static String h1(String str) {
        return header(str, 1);
    }
    public static String h2(String str) {
        return header(str, 2);
    }
    public static String h3(String str) {
        return header(str, 3);
    }
    public static String h4(String str) {
        return header(str, 4);
    }
    public static String table(String str, String caption) {
        return String.format("<table>%n" +
                             "  <caption>%s</caption>%n" +
                             "  %s%n" +
                             "</table>%n",
                             caption, str);
    }
    public static String thead(String str) {
        return String.format("<thead>%s</thead>%n", str);
    }
    public static String tbody(String str) {
        return String.format("<tbody>%s</tbody>%n", str);
    }
    public static String th(String str) {
        return String.format("<th>%s</th>%n", str);
    }
    public static String td(String str) {
        return String.format("<td>%s</td>%n", str);
    }
    public static String tr(String str, String style) {
        return String.format("<tr class=\"%s\">%s</tr>%n", style, str);
    }
}
