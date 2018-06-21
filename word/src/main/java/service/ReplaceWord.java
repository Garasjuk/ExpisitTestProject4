package service;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

public interface ReplaceWord {
    StringBuffer getReplaceWord(XWPFWordExtractor extractor);
}
