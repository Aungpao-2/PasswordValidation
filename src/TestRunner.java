// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)
        check("'Abcdef12' valid", PasswordValidator.validate("Abcdef12"));

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try { PasswordValidator.validate(null); }
        catch (IllegalArgumentException e) { threw = true; }
        check("null -> throws IllegalArgumentException", threw);

        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
        check("ความยาว 7  ", PasswordValidator.validate("Kungof2") == false);
        check("ความยาว 8  ", PasswordValidator.validate("Kungof12") == true);
        check("ความยาว 20 ", PasswordValidator.validate("Kungofjhij1234op6gvM") == true);
        check("ความยาว 21 ", PasswordValidator.validate("Kungofghij123456789Za") == false);

        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> false
        check("ไม่มีตัวพิมพ์ใหญ่ ", PasswordValidator.validate("KFINGK47") == false);

        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
        check("ไม่มีตัวพิมพ์เล็ก ", PasswordValidator.validate("abdkchi8") == false);

        // TODO: R5 - ไม่มีตัวเลข -> false
        check("ไม่มีตัวเลข ", PasswordValidator.validate("58796058") == false);

        // TODO: R6 - มีช่องว่าง -> false
        check("มีช่องว่างตรงกลาง ", PasswordValidator.validate("Abcd ") == false);
        check("มีช่องว่างข้างหน้า ", PasswordValidator.validate(" Abcdef") == false);
        check("มีช่องว่างข้างหลัง ", PasswordValidator.validate("Abcdef ") == false);

        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น

        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}
