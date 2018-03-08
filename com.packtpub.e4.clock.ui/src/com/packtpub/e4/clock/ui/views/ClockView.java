package com.packtpub.e4.clock.ui.views;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;

import com.packtpub.e4.clock.ui.ClockWidget;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import java.util.Date;
import java.util.TimeZone;

import javax.inject.Inject;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class ClockView extends ViewPart {
	private Combo timezones;

	@Override
	public void createPartControl(Composite parent) {
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		parent.setLayout(layout);
		final ClockWidget clock1 = new ClockWidget(parent, SWT.NONE, new RGB(255, 0, 0));
		final ClockWidget clock2 = new ClockWidget(parent, SWT.NONE, new RGB(0, 255, 0));
		final ClockWidget clock3 = new ClockWidget(parent, SWT.NONE, new RGB(0, 0, 255));

		clock1.setLayoutData(new RowData(20, 20));
		clock3.setLayoutData(new RowData(100, 100));

		String[] ids = TimeZone.getAvailableIDs();
		timezones = new Combo(parent, SWT.SIMPLE);
		timezones.setVisibleItemCount(5);
		for (int i = 0; i < ids.length; i++) {
			timezones.add(ids[i]);
		}

		timezones.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String z = timezones.getText();
				TimeZone tz = z == null ? null : TimeZone.getTimeZone(z);
				TimeZone dt = TimeZone.getDefault();
				int offset = tz == null ? 0
						: (tz.getOffset(System.currentTimeMillis()) - dt.getOffset(System.currentTimeMillis()))
								/ 3600000;
				clock3.setOffset(offset);
				clock3.redraw();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				clock3.setOffset(0);
				clock3.redraw();
			}
		});
	}

	@Override
	public void setFocus() {
		timezones.setFocus();
	}
}
