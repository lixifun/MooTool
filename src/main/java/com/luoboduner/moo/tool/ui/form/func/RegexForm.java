package com.luoboduner.moo.tool.ui.form.func;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.luoboduner.moo.tool.App;
import com.luoboduner.moo.tool.dao.TFuncContentMapper;
import com.luoboduner.moo.tool.domain.TFuncContent;
import com.luoboduner.moo.tool.ui.FuncConsts;
import com.luoboduner.moo.tool.ui.component.RegexSyntaxTextViewer;
import com.luoboduner.moo.tool.ui.listener.func.RegexListener;
import com.luoboduner.moo.tool.util.MybatisUtil;
import com.luoboduner.moo.tool.util.ScrollUtil;
import com.luoboduner.moo.tool.util.SqliteUtil;
import com.luoboduner.moo.tool.util.UndoUtil;
import lombok.Getter;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

/**
 * <pre>
 * RegexForm
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2019/12/13.
 */
@Getter
public class RegexForm {
    private JTabbedPane tabbedPane1;
    private JPanel regexPanel;
    private JTextField regexTextField;
    private JButton matchTestButton;
    private JButton favoriteBookButton;
    private JButton addToFavoriteButton;
    private JPanel contentPanel;
    private JLabel matchesLabel;
    private JTextField a139DTextField;
    private JTextField magnetXtUrnBtihTextField1;
    private JTextField idSSTextField;
    private JTextField aFAF09TextField;
    private JTextField httpS12TextField;
    private JTextField aZAZ09_TextField;
    private JTextField httpHttpsAZATextField;
    private JTextField a25052TextField;
    private JTextField aZAZATextField;
    private JTextField u4e00U9fa50$TextField;
    private JTextField aZaZ09TextField;
    private JTextField a320$TextField;
    private JTextField aZaZ$TextField;
    private JTextField w$TextField;
    private JTextField u4E00U9FA5AZaZ0TextField;
    private JTextField $X22TextField;
    private JTextField a19D$TextField;
    private JTextField a19D$TextField2;
    private JTextField a19D$TextField3;
    private JTextField a19D0$TextField;
    private JTextField a19DDTextField;
    private JScrollPane commonRegexScrollPane;

    private RegexSyntaxTextViewer textArea;
    private RTextScrollPane scrollPane;

    private static RegexForm regexForm;

    private static final Log logger = LogFactory.get();

    private static TFuncContentMapper funcContentMapper = MybatisUtil.getSqlSession().getMapper(TFuncContentMapper.class);

    private RegexForm() {
        textArea = new RegexSyntaxTextViewer();
        JTextArea timeHisTextArea = TimeConvertForm.getInstance().getTimeHisTextArea();
        textArea.setSelectionColor(timeHisTextArea.getSelectionColor());
        textArea.setCaretColor(UIManager.getColor("Editor.caretColor"));
        textArea.setMarkAllHighlightColor(UIManager.getColor("Editor.markAllHighlightColor"));
        textArea.setMarkOccurrencesColor(UIManager.getColor("Editor.markOccurrencesColor"));
        textArea.setMatchedBracketBGColor(UIManager.getColor("Editor.matchedBracketBackground"));
        textArea.setMatchedBracketBorderColor(UIManager.getColor("Editor.matchedBracketBorderColor"));
        textArea.setPaintMatchedBracketPair(true);

        scrollPane = new RTextScrollPane(textArea);

        scrollPane.setMaximumSize(new Dimension(-1, -1));
        scrollPane.setMinimumSize(new Dimension(-1, -1));

        Color defaultBackground = App.mainFrame.getBackground();

        Gutter gutter = scrollPane.getGutter();
        gutter.setBorderColor(gutter.getLineNumberColor().darker());
        gutter.setBackground(defaultBackground);

        Font font = new Font(App.config.getFont(), Font.PLAIN, App.config.getFontSize());
        gutter.setLineNumberFont(font);
//            gutter.setLineNumberColor(defaultBackground);
        gutter.setFoldBackground(defaultBackground.darker());
        gutter.setArmedFoldBackground(defaultBackground);
        UndoUtil.register(this);
    }

    public static RegexForm getInstance() {
        if (regexForm == null) {
            regexForm = new RegexForm();
        }
        return regexForm;
    }

    public static void init() {
        regexForm = getInstance();
        regexForm.getContentPanel().add(regexForm.getScrollPane());

        initUi();

        regexForm.getRegexTextField().setText(App.config.getRegexText());

        TFuncContent tFuncContent = funcContentMapper.selectByFunc(FuncConsts.REGEX);
        if (tFuncContent != null) {
            regexForm.getTextArea().setText(tFuncContent.getContent());
        }

        RegexListener.addListeners();
    }

    private static void initUi() {
        regexForm.getAddToFavoriteButton().setIcon(new FlatSVGIcon("icon/favorite.svg"));
        regexForm.getRegexPanel().updateUI();

        ScrollUtil.smoothPane(regexForm.getCommonRegexScrollPane());
    }

    public static int saveContent() {
        regexForm = getInstance();
        String text = regexForm.getTextArea().getText();
        String now = SqliteUtil.nowDateForSqlite();

        TFuncContent tFuncContent = funcContentMapper.selectByFunc(FuncConsts.REGEX);
        if (tFuncContent == null) {
            tFuncContent = new TFuncContent();
            tFuncContent.setFunc(FuncConsts.REGEX);
            tFuncContent.setContent(text);
            tFuncContent.setCreateTime(now);
            tFuncContent.setModifiedTime(now);

            return funcContentMapper.insert(tFuncContent);
        } else {
            tFuncContent.setContent(text);
            tFuncContent.setModifiedTime(now);
            return funcContentMapper.updateByPrimaryKeySelective(tFuncContent);
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        regexPanel = new JPanel();
        regexPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1 = new JTabbedPane();
        regexPanel.add(tabbedPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(12, 12, 12, 12), -1, -1));
        tabbedPane1.addTab("匹配测试", panel1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("正则表达式");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        regexTextField = new JTextField();
        panel3.add(regexTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        favoriteBookButton = new JButton();
        favoriteBookButton.setText("收藏夹");
        panel3.add(favoriteBookButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addToFavoriteButton = new JButton();
        addToFavoriteButton.setIcon(new ImageIcon(getClass().getResource("/icon/favorite.png")));
        addToFavoriteButton.setText("");
        panel3.add(addToFavoriteButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        matchTestButton = new JButton();
        matchTestButton.setText("匹配测试");
        panel3.add(matchTestButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new GridConstraints(1, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("个匹配");
        panel4.add(label2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        matchesLabel = new JLabel();
        Font matchesLabelFont = this.$$$getFont$$$(null, Font.BOLD, -1, matchesLabel.getFont());
        if (matchesLabelFont != null) matchesLabel.setFont(matchesLabelFont);
        matchesLabel.setText("0");
        panel4.add(matchesLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel4.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(0, 0));
        panel1.add(contentPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel5.setMaximumSize(new Dimension(-1, -1));
        panel5.setMinimumSize(new Dimension(-1, -1));
        panel5.setPreferredSize(new Dimension(-1, -1));
        tabbedPane1.addTab("常用正则表达式", panel5);
        commonRegexScrollPane = new JScrollPane();
        panel5.add(commonRegexScrollPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        commonRegexScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(26, 2, new Insets(20, 20, 20, 20), -1, -1));
        commonRegexScrollPane.setViewportView(panel6);
        final Spacer spacer2 = new Spacer();
        panel6.add(spacer2, new GridConstraints(25, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("电话号码");
        panel6.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("电子邮箱");
        panel6.add(label4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("域名");
        panel6.add(label5, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("IPv4");
        panel6.add(label6, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("账号校验");
        panel6.add(label7, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("HTML标签属性(id=\"***\")");
        panel6.add(label8, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("颜色代码(#FFFFFF)");
        panel6.add(label9, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("jpg图片");
        panel6.add(label10, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("磁力链接");
        panel6.add(label11, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a139DTextField = new JTextField();
        a139DTextField.setEditable(false);
        a139DTextField.setText("1[3-9]\\d{9}");
        panel6.add(a139DTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        aZAZ09_TextField = new JTextField();
        aZAZ09_TextField.setEditable(false);
        aZAZ09_TextField.setText("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        panel6.add(aZAZ09_TextField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        httpHttpsAZATextField = new JTextField();
        httpHttpsAZATextField.setEditable(false);
        httpHttpsAZATextField.setText("^((http:\\/\\/)|(https:\\/\\/))?([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}(\\/)");
        panel6.add(httpHttpsAZATextField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a25052TextField = new JTextField();
        a25052TextField.setEditable(false);
        a25052TextField.setText("((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))");
        panel6.add(a25052TextField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        aZAZATextField = new JTextField();
        aZAZATextField.setEditable(false);
        aZAZATextField.setText("^[a-zA-Z][a-zA-Z0-9_]{4,15}$");
        panel6.add(aZAZATextField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        idSSTextField = new JTextField();
        idSSTextField.setEditable(false);
        idSSTextField.setText("(?<=id=\\\")[\\s\\S]*?(?=\\\")");
        panel6.add(idSSTextField, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        aFAF09TextField = new JTextField();
        aFAF09TextField.setEditable(false);
        aFAF09TextField.setText("#([a-fA-F0-9]{6})");
        panel6.add(aFAF09TextField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        httpS12TextField = new JTextField();
        httpS12TextField.setEditable(false);
        httpS12TextField.setText("http[s:]{1,2}//[^\\s'\"<>]*?.jpg");
        panel6.add(httpS12TextField, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        magnetXtUrnBtihTextField1 = new JTextField();
        magnetXtUrnBtihTextField1.setEditable(false);
        magnetXtUrnBtihTextField1.setText("magnet:\\?xt=urn:btih:[0-9a-fA-F]{40,}");
        panel6.add(magnetXtUrnBtihTextField1, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JSeparator separator1 = new JSeparator();
        panel6.add(separator1, new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JSeparator separator2 = new JSeparator();
        panel6.add(separator2, new GridConstraints(10, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("汉字");
        panel6.add(label12, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("英文和数字");
        panel6.add(label13, new GridConstraints(12, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("长度为3-20的所有字符");
        panel6.add(label14, new GridConstraints(13, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("由26个英文字母组成的字符串");
        panel6.add(label15, new GridConstraints(14, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label16 = new JLabel();
        label16.setText("由数字、26个英文字母或者下划线组成的字符串");
        panel6.add(label16, new GridConstraints(15, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setText("中文、英文、数字包括下划线");
        panel6.add(label17, new GridConstraints(16, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label18 = new JLabel();
        label18.setText("禁止输入含有%',;=?$\"等字符");
        panel6.add(label18, new GridConstraints(17, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label19 = new JLabel();
        label19.setText("整数");
        panel6.add(label19, new GridConstraints(18, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label20 = new JLabel();
        label20.setText("正整数 ");
        panel6.add(label20, new GridConstraints(20, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label21 = new JLabel();
        label21.setText("负整数");
        panel6.add(label21, new GridConstraints(21, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label22 = new JLabel();
        label22.setText("非负整数");
        panel6.add(label22, new GridConstraints(22, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label23 = new JLabel();
        label23.setText("浮点数");
        panel6.add(label23, new GridConstraints(23, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        u4e00U9fa50$TextField = new JTextField();
        u4e00U9fa50$TextField.setEditable(false);
        u4e00U9fa50$TextField.setText("^[\\u4e00-\\u9fa5]{0,}$");
        panel6.add(u4e00U9fa50$TextField, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        aZaZ09TextField = new JTextField();
        aZaZ09TextField.setEditable(false);
        aZaZ09TextField.setText("^[A-Za-z0-9]+$");
        panel6.add(aZaZ09TextField, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a320$TextField = new JTextField();
        a320$TextField.setEditable(false);
        a320$TextField.setText("^.{3,20}$");
        panel6.add(a320$TextField, new GridConstraints(13, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        aZaZ$TextField = new JTextField();
        aZaZ$TextField.setEditable(false);
        aZaZ$TextField.setText("^[A-Za-z]+$");
        panel6.add(aZaZ$TextField, new GridConstraints(14, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        w$TextField = new JTextField();
        w$TextField.setEditable(false);
        w$TextField.setText("^\\w+$");
        panel6.add(w$TextField, new GridConstraints(15, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        u4E00U9FA5AZaZ0TextField = new JTextField();
        u4E00U9FA5AZaZ0TextField.setEditable(false);
        u4E00U9FA5AZaZ0TextField.setText("^[\\u4E00-\\u9FA5A-Za-z0-9_]+$");
        panel6.add(u4E00U9FA5AZaZ0TextField, new GridConstraints(16, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        $X22TextField = new JTextField();
        $X22TextField.setEditable(false);
        $X22TextField.setText("[^%&',;=?$\\x22]+");
        panel6.add($X22TextField, new GridConstraints(17, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a19D$TextField = new JTextField();
        a19D$TextField.setEditable(false);
        a19D$TextField.setText("^-?[1-9]\\d*$");
        panel6.add(a19D$TextField, new GridConstraints(18, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a19D$TextField2 = new JTextField();
        a19D$TextField2.setEditable(false);
        a19D$TextField2.setText("^[1-9]\\d*$");
        panel6.add(a19D$TextField2, new GridConstraints(20, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a19D$TextField3 = new JTextField();
        a19D$TextField3.setEditable(false);
        a19D$TextField3.setText("^-[1-9]\\d*$");
        panel6.add(a19D$TextField3, new GridConstraints(21, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a19D0$TextField = new JTextField();
        a19D0$TextField.setEditable(false);
        a19D0$TextField.setText("^[1-9]\\d*|0$");
        panel6.add(a19D0$TextField, new GridConstraints(22, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a19DDTextField = new JTextField();
        a19DDTextField.setEditable(false);
        a19DDTextField.setText("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$");
        panel6.add(a19DDTextField, new GridConstraints(23, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JSeparator separator3 = new JSeparator();
        panel6.add(separator3, new GridConstraints(19, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel6.add(panel7, new GridConstraints(24, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label24 = new JLabel();
        label24.setText("以上大部分来自：https://github.com/cdoco/common-regex, MIT License by cdoco/common-regex, Copyright (c) 2016 ZiHang Gao <ocdoco@gmail.com>");
        panel7.add(label24, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JSeparator separator4 = new JSeparator();
        panel7.add(separator4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return regexPanel;
    }

}
