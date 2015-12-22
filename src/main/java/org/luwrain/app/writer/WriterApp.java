/*
   Copyright 2012-2015 Michael Pozhidaev <michael.pozhidaev@gmail.com>

   This file is part of the LUWRAIN.

   LUWRAIN is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public
   License as published by the Free Software Foundation; either
   version 3 of the License, or (at your option) any later version.

   LUWRAIN is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   General Public License for more details.
*/

package org.luwrain.app.writer;

import java.util.*;
import java.io.*;
import java.nio.charset.*;

import org.luwrain.core.*;
import org.luwrain.core.events.*;
import org.luwrain.controls.*;
import org.luwrain.popups.*;

class WriterApp implements Application, Actions
{
static public final String STRINGS_NAME = "luwrain.writer";

    private Luwrain luwrain;
    private final Base base = new Base();
    private Strings strings;
    private Area area;

    private String arg = null;

    WriterApp()
    {
    }

    WriterApp(String arg)
    {
	this.arg = arg;
	NullCheck.notNull(arg, "arg");
    }

    @Override public boolean onLaunch(Luwrain luwrain)
    {
	final Object o = luwrain.i18n().getStrings(STRINGS_NAME);
	if (o == null || !(o instanceof Strings))
	    return false;
	strings = (Strings)o;
	this.luwrain = luwrain;
	if (!base.init(luwrain))
	    return false;
	createArea();
	return true;
    }

    @Override public String getAppName()
    {
	return strings.appName();
    }

    private void createArea()
    {
	base.createNewDoc();
	area = new Area(new DefaultControlEnvironment(luwrain), this, base.getRootBodyView());
    }

    @Override public AreaLayout getAreasToShow()
    {
	return new AreaLayout(area);
    }

    @Override public void closeApp()
    {
	luwrain.closeApp();
    }
}
