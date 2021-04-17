package com.michael;

import java.util.Scanner;

public class StackDemo {
	public static void main(String[] args) {
		StackOrigin s1 = new StackOrigin(4);
		String key ="";
		boolean  loop = true;
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("show:show stack");
			System.out.println("exit:exit progrmmer");
			System.out.println("push:push stack");
			System.out.println("pop:pop stack");
			System.out.println("please choose your choice");
			key = scanner.next();
			switch(key) {
			case "show":
				s1.list();
				break;
			case "push":
				System.out.println("please enter the value");
				int value = scanner.nextInt();
				s1.push(value);
				break;
			case "pop":
				int result = s1.pop();
				System.out.printf("stack pop %d\n",result);
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			}
		}
		System.out.println("Progrmming exiting...");
	}
}
class StackOrigin{
	private int maxSize;
	private int top = -1;
	private int[] stack;
	
	public StackOrigin(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("stack is full");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	public void list() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
}