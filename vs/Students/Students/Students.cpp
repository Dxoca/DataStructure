// Students.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"
#include <iostream>
#include <istream>
#include <stdio.h>
#include <windows.h>  
#include <stdlib.h>  
#include <string.h>  
#include<fstream>

using namespace std;
/**
时间线：
2019年12月5日09:36:52   完成interface的撰写
**/
#define N 5 //考试门数 
#define st  s->student //指针代替
#define sti  p->student //指针代替
struct Student
{
	int id = 0;
	char name[10] = "不知道";//名字一个字2个字节 
	char sex[3] = "男"; //性别 0男 1女
	int age = 19;
	int score[N];
	char phone[13] = "18194598944"; //用字符串保持大整数 
};

// 节点
typedef struct Student ElemType;
typedef struct Node
{
	ElemType student;
	struct Node *next;
}Node, *LinkList;


//interface
void befor(LinkList &p);// 初始化数据输入  txt 文本 

void insert(LinkList & L);

void printInput(LinkList &L); // 输出所有输入的数据
void init(LinkList &L);//初始化空表函数
void create(LinkList &L);// 创建函数 
void destory(Student &stud); //销毁函数
void full();//判断是否满 
bool isEmpty();//判断是否为空 
int count(LinkList &L);//计数函数 

void insert(Student &stud);// 插入（增加）学生 
void del(Student &stud);// 删除学生 
void changeAge(Student &stud, int e);//修改年龄 
void scoreList(Student &stud);//输出成绩表 不能修改 
Student byIdSearch(int id);//通过学号查询完整信息 
void sensusSex(Node &p);//统计男女生人数
void topScoreOfCourse(Node &p, int i);
void sort();

//实现 

/**
 * 初始化数据输入
 * 1.用数组score存放先设定可以存入本班所有人的信息（文件调入）
 * 2.输出学生完整信息 【print_input()】
 * 3.后一行显示学生人数。
 *
**/
void befor(LinkList &L)
{



}
/**
 * 1. 判断是否满 *
 * 2. 增加学生
 * 3. 人数count ++
 * 4. 输出人数
**/

void init(LinkList &L)
{
	L = new Node;
	L->next = NULL;
}
void create(LinkList &L)
{

}
void insertNode(LinkList &L, Node &node) {

}
void insert(LinkList &L)
{
	LinkList p = L, s;
	while (p->next != NULL)
	{
		p = p->next;
	}
	cout << "学号\t" << " 姓名\t" << "性别 " << "年龄  " << "手机号\t " << N << "门课成绩" << endl;

	s = new Node;

	cin >> st.id >> st.name >> st.sex >> st.age >> st.phone;
	for (int i = 0; i < N; i++)
	{
		cin >> st.score[i];
	}
	s->next = p->next;
	p->next = s;
}
void printInput(LinkList &L)//打印输出 所有
{
	LinkList p = L->next;
	while (p != NULL)
	{
		cout << sti.id << sti.name << sti.sex << sti.age << sti.phone << endl;
		cout << "成绩" << endl;
		for (int i = 0; i < N; i++)
		{
			cout << sti.score[i] << "\t";
		}
		p = p->next;
		cout << endl;
	}
}
//计数 
int count(LinkList &L)
{
	LinkList p = L->next;//p为头指针
	int count = 0;
	while (p)
	{
		//cout << p->student.id << endl;
		p = p->next;
		count++;
	}
	return count;
}

bool isEmpty(LinkList &L)
{
	if (count(L) == 0)
		return true;
	return false;
}
/**
  * 1. 判断是空 *
  * 2. 删除学生
  * 3. 人数count--
  * 4. 输出人数
 **/
void del(Student &stud)
{

}

/**
 * 1.判断 年龄是否规范
 * 1.判断是否有学生
 * 2.修改年龄
**/
void changeAge(Student &stud, int e)
{

}
/**
* 1.判断不是空表
* 1.遍历  【是否使用迭代器呢？！】
* 2.输出所有学生的成绩
**/
void scoreList(Student &stud)
{

}
/**
 * 1.便利list
 * 2. 统计 男 女人数
 * 3. 输出
 **/
void censusSex(Node &p)
{

}
/**
   指定找到某课程的最高分，显示该学生学号，姓名，分数。
**/
void topScoreOfCourse(Node &p, int i)
{

}
/**
   将成绩排序由小到大，输出学生的学号，姓名，总分数。
**/
void sort()
{

}
/// 菜单部分
void welocome()//登陆界面  
{
	system("color b1");
	printf("````````````````````````````````````````````````````````````````````````````````");
	printf("\n");
	printf("\n");
	printf("\n");
	printf("  ***********************  欢迎登录学生信息管理平台 *************************  \n");
	printf("\n");
	printf("\n");
	printf("\n");
	printf("`````````````````````````````````````````````````````by：王珍山 龚泽儒``````````");
	cout << endl;
}
void menu()//功能菜单  
{
	system("color e3");
	printf("    |________________________________________________|\n");
	printf("    |                                                |\n");
	printf("    |                学生信息管理系统                |\n");
	printf("    |                                                |\n");
	printf("    |               0、退出系统                      |\n");
	printf("    |               1、增加学生信息                  |\n");
	printf("    |               2、删除学生信息                  |\n");
	printf("    |               3、修改学生信息                  |\n");//修改年龄 名字 性别 年龄 手机号 成绩
	printf("    |               4、查找学生完整信息              |\n");//通过 学号、姓名 查询
	printf("    |               5、学生成绩相关操作              |\n");//1.计算 求和成绩 平均分 2.查找课程指定最高分数 3.成绩从小到大排序
	printf("    |               6、浏览全部学生信息              |\n");
	printf("    |               7、保存学生信息到文件            |\n");
	printf("    |               8、载入学生信息文件到系统        |\n");
	printf("    |                                                |\n");
	printf("    |________________________________________________|\n");
	return;
}

//fscanf(fp, " %d %s %s %d %s %d %d %d %d %d", &stu.id, &stu.name, &stu.sex, &stu.age, &stu.phone, &stu.score[0], &stu.score[1], &stu.score[2], &stu.score[3], &stu.score[4]);

//1806030630 王珍山  男 18 181945989844 12 12 12 12 12 
int main(int argc, char** argv) {
	system("cls");//清屏  
	welocome();//登陆界面  
	Sleep(3000);//延缓3秒  
	int choose = 0;

	LinkList L;
	init(L);

	

	while (true)
	{
		printf("请输入您要选择的功能键：\n");
		menu();//功能菜单  
		cin >> choose;
		switch (choose) {
		case 0://退出  
			printf("谢谢使用！欢迎下次光临");
			exit(0);

		default:
			printf("请输入正确的选择\n");
			break;


		}

	}

	/**
	LinkList List;
	init(List);//初始化
	insert(List);//插入一条
	insert(List);

	printInput(List);//打印所有信息
	cout<<count(List);
	*/
}