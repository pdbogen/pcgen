/*
 * Copyright 2009 (C) James Dempsey
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.core.term;

import pcgen.core.Equipment;
import pcgen.core.PlayerCharacter;

/**
 * The Class {@code EQHeadPlusTotalTermEvaluator} is responsible for producing
 * the value of the HEADPLUSTOTAL token for use in equipment and eqmod cost formulas.
 * This is the total plus modifier for the current head.  
 */
public class EQHeadPlusTotalTermEvaluator extends BaseEQTermEvaluator implements TermEvaluator
{
	
	/**
	 * Instantiates a new EQHeadPlusTotalTermEvaluator.
	 * 
	 * @param expressionString the expression string
	 */
	public EQHeadPlusTotalTermEvaluator(String expressionString)
	{
		this.originalText = expressionString;
	}

	@Override
	public Float resolve(
			Equipment eq,
			boolean primary,
			PlayerCharacter pc)
	{
		return TermUtil.convertToFloat(originalText, evaluate(eq, primary, pc));
	}

	@Override
	public String evaluate(
			Equipment eq,
			boolean primary,
			PlayerCharacter pc) {
		return Integer.toString(eq.calcPlusForHead(primary));
	}

	/* (non-Javadoc)
	 * @see pcgen.core.term.TermEvaluator#isSourceDependant()
	 */
	@Override
	public boolean isSourceDependant()
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see pcgen.core.term.TermEvaluator#isStatic()
	 */
	public boolean isStatic()
	{
		return false;
	}
	
}
