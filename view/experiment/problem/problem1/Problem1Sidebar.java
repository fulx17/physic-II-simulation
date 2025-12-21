package view.experiment.problem.problem1;
import controller.ExperimentController;
import view.experiment.base.BaseSidebar;

public class Problem1Sidebar extends BaseSidebar {
    
    public Problem1Sidebar(ExperimentController expCtr) {
        
    }
    @Override
    protected String createNote() {
        return """
        • Giữ và di chuột để kéo đồ vật
        • Giữ và di vào phần trống để kéo màn hình
        • Dùng lăn chuột để thu phóng
        • Nhấp chuột và ấn backspace để xóa dây
        • Kéo giắc cắm đến gần ổ rồi thả để cắm dây
        • Kéo giắc cắm ra khỏi ổ để tháo dây
        • Nối theo gợi ý màu xanh, bỏ dây theo gợi ý đỏ
        • Ấn nút "ghi chú" lần nữa để đóng

        Checking
        • Kiểm tra 1: kiểm tra mạch cầu Wheatston
        • Kiểm tra 2: kiểm tra mạch xung đối với nguồn chuẩn
        • Kiểm tra 3: kiểm tra mạch xung đối với nguồn ẩn
        """;
    }
}
