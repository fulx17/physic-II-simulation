package view.instruction;

import javax.swing.*;
import java.awt.*;

public class InstructionTextPanel extends JPanel {
    
    // Mình sửa lại nội dung HTML một chút để căn giữa text cho đẹp luôn
    private static String instruction = "Đây là phần mềm mô phỏng các bài thí nghiệm môn Vật lí Đại cương II của HUST. Phần mềm này ra đời giúp mọi người luyện tập mắc mạch để chuẩn bị cho buổi bảo vệ. Mỗi bài thí nghiệm sẽ có các dụng cụ và hướng dẫn tương ứng được ghi ở phần ghi chú(góc dưới phải màn hình). Do đây là bản đầu tiên nên chỉ có chức năng nối dây và có 1 đáp án duy nhất, các đáp án đều được rút ra thông qua mạch nhóm mình. Đây chỉ là phần mềm tham khảo, chưa chắc phải đáp án chính xác nên mọi người hãy kiểm tra kĩ càng. Mọi người thấy có ích thì donate mình một ít ăn mì tôm nhé:((";

    public InstructionTextPanel() {
        // 1. Layout chính của toàn bộ Panel
        setLayout(new BorderLayout());

        // 2. Tạo Panel chứa nội dung (Container)
        // Dùng BoxLayout theo chiều dọc (Y_AXIS) để xếp: Chữ ở trên -> Ảnh ở dưới
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(205, 221, 237));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Tạo lề cho thoáng

        // --- PHẦN 1: CHỮ ---
        JLabel textLabel = new JLabel("<html><body style='width: 800px; text-align: justify;'>" + instruction + "</body></html>");
        textLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo trục dọc
        
        contentPanel.add(textLabel);
        
        // Tạo khoảng cách giữa chữ và ảnh (20px)
        contentPanel.add(Box.createVerticalStrut(20));

        // --- PHẦN 2: ẢNH (QR Code) ---
        // Thay đường dẫn ảnh của bạn vào đây (ví dụ: "src/assets/qr_momo.png")
        ImageIcon originalIcon = new ImageIcon("assets/qr.jpg"); 
        
        // Logic resize ảnh nếu ảnh quá to (Ví dụ chỉnh về 300x300)
        Image image = originalIcon.getImage(); 
        Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon newIcon = new ImageIcon(newimg);
        
        JLabel imageLabel = new JLabel(newIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa ảnh
        
        contentPanel.add(imageLabel);



        // 3. Scroll Panel (Để bao bọc contentPanel)
        // Cần thêm 1 panel wrapper để giữ cho contentPanel luôn ở giữa màn hình nếu nội dung ngắn
        JPanel wrapperPanel = new JPanel(new GridBagLayout()); 
        wrapperPanel.setBackground(new Color(205, 221, 237));
        wrapperPanel.add(contentPanel);

        JScrollPane scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(18);

        // add
        add(scrollPane, BorderLayout.CENTER);
    }
}