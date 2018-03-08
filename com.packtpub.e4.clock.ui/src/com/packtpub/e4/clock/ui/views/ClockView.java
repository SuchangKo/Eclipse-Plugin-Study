package com.packtpub.e4.clock.ui.views;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;

import com.packtpub.e4.clock.ui.ClockWidget;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;

import java.util.Date;

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
	@Override
	public void createPartControl(Composite parent) {
		final ClockWidget clock1 = new ClockWidget(parent, SWT.NONE);
		final ClockWidget clock2 = new ClockWidget(parent, SWT.NONE);
		final ClockWidget clock3 = new ClockWidget(parent, SWT.NONE);
	}

	@Override
	public void setFocus() {

	}
}
