class LibraryMember {

    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {

        this.memberName = memberName;
        this.memberId = memberId;
    }

    double calculateFine(int overdueDays) {
        return 0;
    }

    void display() {

        System.out.println(memberName +
                " | " + memberId);
    }
}

class StudentMember extends LibraryMember {

    StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }
}

class FacultyMember extends LibraryMember {

    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 1;
    }
}

class GuestMember extends LibraryMember {

    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }
}

public class SmartLibraryMembershipSystem {

    public static void main(String[] args) {

        LibraryMember[] members = {

                new StudentMember("Aman", "S101"),
                new FacultyMember("Dr. Sharma", "F201"),
                new GuestMember("Rahul", "G301")
        };

        int overdueDays = 4;

        System.out.println("Library Members\n");

        for (LibraryMember member : members) {

            member.display();

            System.out.println("Fine = ₹" +
                    member.calculateFine(overdueDays));

            System.out.println();
        }

        String searchId = "F201";

        boolean found = false;

        for (LibraryMember member : members) {

            if (member.memberId.equals(searchId)) {

                System.out.println("Member Found");
                member.display();

                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Member Not Found");
    }
}