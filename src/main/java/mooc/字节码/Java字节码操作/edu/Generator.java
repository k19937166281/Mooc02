package mooc.字节码.Java字节码操作.edu;


import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generator {

	public static void main(String[] args) throws Exception {
		modifyGreeting();
		createAsmGreeting();
	}

	public static void modifyGreeting() throws IOException {
		// 读取
		ClassReader classReader = new ClassReader("mooc/字节码/Java字节码操作/Greeting");
		//构建
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		// 处理
		ClassVisitor classVisitor = new MyClassVisitor(classWriter);
		classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
		byte[] data = classWriter.toByteArray();
		// 输出
		File f = new File("target/classes/mooc/字节码/Java字节码操作/Greeting.class");
		FileOutputStream fout = new FileOutputStream(f);
		fout.write(data);
		fout.close();
		System.out.println("Modify Greeting Class success!!!!!");
	}

	public static void createAsmGreeting() throws Exception {

		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;
		//主版本号设为49，JDK5之后都可以运行
		cw.visit(49, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER, "mooc/字节码/Java字节码操作/AsmGreeting", null, "java/lang/Object", null);

		cw.visitSource("AsmGreeting.java", null);

		// 无参构造方法
		mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitVarInsn(Opcodes.ALOAD, 0); // 将this放入栈顶

		//调用super()
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(1, 1);
		mv.visitEnd();

		// hello方法，无参无返回值
		mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "hello", "()V", null, null);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn("Hello, this class is genrated by ASM");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(2, 1);
		mv.visitEnd();

		cw.visitEnd();


		File f = new File("target/classes/mooc/字节码/Java字节码操作/AsmGreeting.class");
		FileOutputStream fout = new FileOutputStream(f);
		fout.write(cw.toByteArray());
		fout.close();
		System.out.println("Create AsmGreeting success!!!!!");
	}
}
