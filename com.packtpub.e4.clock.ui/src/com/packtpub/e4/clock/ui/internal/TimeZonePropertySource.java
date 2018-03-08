package com.packtpub.e4.clock.ui.internal;

import java.util.Date;
import java.util.TimeZone;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class TimeZonePropertySource implements IPropertySource {
	private TimeZone timeZone;

	public TimeZonePropertySource(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	private static final Object ID = new Object();
	private static final Object DAYLIGHT = new Object();
	private static final Object NAME = new Object();
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return new IPropertyDescriptor[] { new PropertyDescriptor(ID, "Time Zone"),
				new PropertyDescriptor(DAYLIGHT, "Daylight Savings"), new PropertyDescriptor(NAME, "Name") };
	}
	@Override
	public Object getPropertyValue(Object id) {
		if (ID.equals(id)) {
			return timeZone.getID();
		} else if (DAYLIGHT.equals(id)) {
			return timeZone.inDaylightTime(new Date());
		} else if (NAME.equals(id)) {
			return timeZone.getDisplayName();
		} else {
			return null;
		}
	}

	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPropertySet(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPropertyValue(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}