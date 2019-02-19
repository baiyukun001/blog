package com.waylau.spring.boot.blog.util;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.options.MutableDataSet;
import com.waylau.spring.boot.blog.vo.Markdown;

import java.util.Arrays;

public class MarkDown2HtmlWrapper {

    private static String MD_CSS = null;

    static {
        try {
            MD_CSS = FileReadUtil.readAll("md/huimarkdown.css");
            MD_CSS = "<style type=\"text/css\">\n" + MD_CSS + "\n</style>\n";
        } catch (Exception e) {
            MD_CSS = "";
        }
    }

    /**
     * 直接将markdown语义的文本转为html格式输出
     */
    public static Markdown ofContent(String content) {
        String html = parse(content);
        Markdown markdown = new Markdown();
        markdown.setCss(MD_CSS);
        markdown.setHtml(html);
        markdown.addDivStyle("class", "markdown-body ");
        return markdown;
    }


    /**
     * markdown to image
     */
    public static String parse(String content) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);

        // enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));


        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(content);
        return renderer.render(document);
    }

}
