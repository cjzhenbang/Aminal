import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //创建一个list集合用于保存动物信息
        ArrayList<Animal> animals=new ArrayList<Animal>();
        boolean flag=true;
        while(flag){
            //菜单系统
            System.out.println("-----------------------");
            System.out.println("输入1增添动物信息");
            System.out.println("输入2删除动物信息");
            System.out.println("输入3修改动物信息");
            System.out.println("输入4输出动物信息");
            System.out.println("输入5退出程序");
            System.out.println("************************");
            Scanner sc = new Scanner(System.in);
            //输出数字选择进入对应功能
            String input = sc.nextLine();
            switch (input)
            {
                case"1":
                    addAnimal(animals);
                    break;
                case"2":
                    removeAnimal(animals);
                    break;
                case"3":
                    modifyAnimal(animals);
                    break;
                case "4":
                    findAll(animals);
                    break;
                case "5":
                    flag=false;
                    break;
                default:
                    System.out.println("输入数字错误");
                    break;
            }
        }
    }
    //增加动物信息的方法
    public static void addAnimal(ArrayList<Animal> animals)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入动物的性别：");
        String gender = sc.nextLine();
        String species=null;
        boolean flag=true;
        while(flag)
        {
            System.out.println("请输入动物种类：");
            species = sc.nextLine();
            if (animals.size()==0)
            {
                flag=false;
            }
            for (int i=0;i<animals.size();i++)
            {
                Animal animal = animals.get(i);
                if(animal.getSpecies().equals(species))
                {
                    System.out.print("该种类动物已存在，");
                    break;
                }
                else{
                    flag=false;
                }
            }
        }
        System.out.println("请输入动物的年龄：");
        int age= sc.nextInt();
        sc.nextLine();
        animals.add(new Animal(gender,species,age));
        System.out.println("动物信息添加成功");
    }

    //删除动物信息的方法
    public static void removeAnimal(ArrayList<Animal> animals)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的动物种类：");
        String species = sc.nextLine();
        int temp=-1;
        for (int i=0;i<animals.size();i++)
        {
            Animal animal = animals.get(i);
            if(animal.getSpecies().equals(species))
            {
                temp=i;
                break;
            }
        }
        if (temp==-1){
            System.out.println("未找到相应动物");
        }else
        {
            animals.remove(temp);
            System.out.println("该动物删除成功");
        }
    }

    //修改动物信息的方法
    public static void modifyAnimal(ArrayList<Animal> animals)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的动物种类：");
        String species = sc.nextLine();
        int temp=-1;
        for (int i=0;i<animals.size();i++)
        {
            Animal animal = animals.get(i);
            if(animal.getSpecies().equals(species))
            {
                temp=i;
                break;
            }
        }
        if (temp==-1){
            System.out.println("未找到相应动物");
        }else
        {
            System.out.println("请输入修改后动物的种类：");
            String specie = sc.nextLine();
            System.out.println("请输入修改后动物的年龄：");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("请输入修改后动物的性别：");
            String gender = sc.nextLine();
            Animal animal = new Animal(gender, specie, age);
            animals.set(temp,animal);
            System.out.println("修改动物信息成功");
        }
    }

    //查找所有动物信息的方法并根据年龄排序
    public static void findAll(ArrayList<Animal> animals)
    {
        if (animals.size()==0)
        {
            System.out.println("列表为空");
            return;
        }
        for (int i=0;i<animals.size();i++)
        {
            for(int j=0;j<animals.size()-1;j++){
                if (animals.get(j).getAge()>animals.get(j+1).getAge()){
                    Animal temp=animals.get(j);
                    animals.set(j,animals.get(j+1));
                    animals.set(j+1,temp);
                }
            }
        }
        for (int i=0;i<animals.size();i++)
        {
            System.out.println("动物种类"+(i+1)+":"+animals.get(i).getSpecies()+"\n动物性别"+(i+1)+":"+animals.get(i).getGender()+"\n动物年龄"+(i+1)+":"+animals.get(i).getAge());
        }
    }
}