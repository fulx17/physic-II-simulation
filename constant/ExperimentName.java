package constant;

public class ExperimentName {
    private static String[] name = {" ", 
        "Đo điện trở suất bằng mạch cầu Wheatston, Đo suất điện động bằng mạch xung đối",
        "Khảo sát điện trường của tụ điện phẳng, xác định hằng số điện môi của teflon",
        "Khảo sát mạch cộng hưởng RLC bằng dao động ký điện tự",
        "Khảo sát và đo cảm ứng từ dọc theo chiều dài một ống dây thẳng dài",
        "Khảo sát hiện tượng từ trễ, xác định năng lượng tổn hao từ hóa sắt từ",
        "Xác định điện tích riêng của Electron bằng phương pháp Magnetron"
    };
    public static String getName(int id) {
        return name[id];
    }
}
