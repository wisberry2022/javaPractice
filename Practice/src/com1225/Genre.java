package Practice.com1225;

class Genre {
    String name;
}

class Mystery extends Genre {
    String name;
    public Mystery() {
        this.name = "Mystery";
    }

    void show() {
        System.out.println("----------------------------------");
        System.out.println(this.name);
        System.out.println(super.name);
        System.out.println("----------------------------------");
    }
}

class Romance extends Genre {
    String name;
    public Romance() {
        this.name = "Romance";
    }
    void show() {
        System.out.println("----------------------------------");
        System.out.println(this.name);
        System.out.println(super.name);
        System.out.println("----------------------------------");
    }
}

class Thriller extends Genre {
    String name;
    public Thriller() {
        this.name = "Thriller";
    }
    void show() {
        System.out.println("----------------------------------");
        System.out.println(this.name);
        System.out.println(super.name);
        System.out.println("----------------------------------");
    }
}

class Kid extends Genre {
    String name;
    public Kid() {
        this.name = "Kid";
    }
    void show() {
        System.out.println("----------------------------------");
        System.out.println(this.name);
        System.out.println(super.name);
        System.out.println("----------------------------------");
    }
}

//class Mystery extends Genre {
//	String name = "Mystery";
//}
//
//class Romance extends Genre {
//	String name = "Romance";
//}
//
//class Thriller extends Genre {
//	String name = "Thriller";
//}
//
//class Kid extends Genre {
//	String name = "Kid";
//}

class Lullaby {
    String name;
    public Lullaby() {
        this.name = "goosebumps";
    }
}
