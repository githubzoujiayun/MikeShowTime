package mikeshowtime.action;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;

public class ShowTime implements IStartup{
	@Override
	public void earlyStartup() {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				long time = Long.parseLong(System.getProperty("eclipse.startTime"));
				long costTime = System.currentTimeMillis() - time;
				Shell shell = Display.getDefault().getActiveShell();
				String message = "Eclipse 启动耗时：" + costTime + "ms";
				MessageDialog.openInformation(shell, "启动时间", message);
			}
		});
	}
}
