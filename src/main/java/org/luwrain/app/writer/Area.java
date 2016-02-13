
package org.luwrain.app.writer;

import org.luwrain.core.*;
import org.luwrain.core.events.*;
import org.luwrain.controls.*;

class Area extends NavigateArea
{
    private ControlEnvironment environment;
    private Actions actions;
    private View view;

    Area(ControlEnvironment environment, Actions actions,
	 View view)
    {
	super(environment);
	this.environment = environment;
	this.actions = actions;
	this.view = view;
	NullCheck.notNull(environment, "environment");
	NullCheck.notNull(actions, "actions");
	NullCheck.notNull(view, "view");
    }

    @Override public boolean onKeyboardEvent(KeyboardEvent event)
    {
	NullCheck.notNull(event, "event");
	return super.onKeyboardEvent(event);
    }

    @Override public boolean onEnvironmentEvent(EnvironmentEvent event)
    {
	NullCheck.notNull(event, "event");
	switch(event.getCode())
	{
	case CLOSE:
	    actions.closeApp();
	    return true;
	case SAVE:
	    //			actions.save();
	    return true;
	case ACTION:
	    //			if (ActionEvent.isAction(event, "remove-backslash-r"))
	    //			{
	    //			    actions.removeBackslashR();
	    //			    return true;
	    //			}
	    return false;
	default:
	    return super.onEnvironmentEvent(event);
	}
    }
    @Override public Action[] getAreaActions()
    {
	return new Action[]{
	    //			new Action("remove-backslash-r", strings.actionTitle("remove-backslash-r")),
	};
    }

    @Override public int getLineCount()
    {
	return view.getLineCount();
    }

    @Override public String getLine(int index)
    {
	return view.getLine(index);
    }

    @Override public String getAreaName()
    {
	return "FIXME";
    }
}
