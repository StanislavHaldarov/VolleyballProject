public class VolleyballPlayer implements Trainable{
    private String name;
    private int age;
    private String position;
    private int skill; //(1-10)
    private int stamina; //(1-5)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) throws Exception {
        if(skill<1 || skill>10)
        {
            throw new Exception("values between 1 and 10 are available!");
        }
        this.skill = skill;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) throws Exception {
        if(stamina<1 || stamina>10)
        {
            throw new Exception("Values between 1 and 5 are available!");
        }
        this.stamina = stamina;
    }

    public VolleyballPlayer() {
        this.name = "default";
        this.age = 0;
        this.position = "default";
        this.skill = 0;
        this.stamina = 0;
    }

    public VolleyballPlayer(String name, int age, String position, int skill, int stamina) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.skill = skill;
        this.stamina = stamina;
    }
    public void train() throws Exception {
        if(getSkill()==10)
        {
            System.out.println(getName() + ", no more room for improvement!");
        }
        else {
            if(getStamina()<2)
            {
                System.out.println(getName() + ", get some rest first!");
            }
            else {
                setSkill(skill+=1);
                setStamina(stamina-=1);
                System.out.println(getName() + "'s training was successful! \nCurrent skill base: " + getSkill() + "/10 \nCurrent stamina: " + getStamina() + "/5");
            }
        }
    }
    public void rest() throws Exception {
        if(getStamina()>=5)
        {
            System.out.println(getName() + "'s stamina is already full!");
        }
        else {
            setStamina(stamina+=1);
            System.out.println(getName() + ", took a break. \nCurrent stamina: " + getStamina() + "/5");

        }
    }

    @Override
    public String toString() {
        return "\nVolleyballPlayer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", skill=" + skill +
                ", stamina=" + stamina +
                '}';
    }
}
