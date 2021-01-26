package mooc.字节码.Java字节码操作.edu;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyClassVisitor extends ClassVisitor implements Opcodes {
	private static String methodName;

	public MyClassVisitor(ClassVisitor cv) {
		super(ASM5, cv);
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		cv.visit(version, access, name, signature, superName, interfaces);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        System.out.println("调用visitMethod");
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
		// 忽略构造方法
		if (!name.equals("<init>") && mv != null) {
			methodName = name;
			mv = new MyMethodVisitor(mv);
		}
		return mv;
	}





	class MyMethodVisitor extends MethodVisitor implements Opcodes {
		public MyMethodVisitor(MethodVisitor mv) {
			super(Opcodes.ASM5, mv);
		}

		@Override
        public void visitCode() {
			super.visitCode();
			//方法进入时打印信息
			//拿到java.lang.System类的.out static字段，并放入栈顶
			mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
			// 将待输出信息放入栈顶
			mv.visitLdcInsn("method " + methodName + " is starting");
			//调用println方法
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		}

		@Override
        public void visitInsn(int opcode) {
			// 判断return或抛出异常
			if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
				mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
				mv.visitLdcInsn("method " + methodName + " is ending");
				mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
			}
			mv.visitInsn(opcode);

			for (;;){
                System.out.println();
            }

		}
	}

//	class MyFieldVistor extends FieldVisitor implements Opcodes{
//
//        public MyFieldVistor(int api) {
//            super(api);
//        }
//
//
//        @Override
//        public void visitEnd() {
//            super.visitEnd();
//        }
//    }


}
