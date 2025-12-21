package view.experiment.base;

import javax.swing.*;
import java.awt.*;

public abstract class BaseSidebar extends JPanel {

    protected JTextArea noteArea;

    public BaseSidebar() {
        setPreferredSize(new Dimension(300, 0));
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245));

        JLabel title = new JLabel("Ghi chú");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 26f));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        noteArea = new JTextArea();
        noteArea.setFont(title.getFont().deriveFont(16f));
        noteArea.setEditable(false);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        noteArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(noteArea);
        scrollPane.setBorder(null);

        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        reloadNote();
    }

    /** Mỗi experiment tự định nghĩa nội dung */
    protected abstract String createNote();

    /** Có thể gọi lại nếu muốn cập nhật nội dung */
    public void reloadNote() {
        noteArea.setText(createNote());
        noteArea.setCaretPosition(0);
    }
}
