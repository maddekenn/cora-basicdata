/*
 * Copyright 2021 Uppsala University Library
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.uu.ub.cora.basicdata.converter.datatojson;

import se.uu.ub.cora.json.builder.JsonArrayBuilder;
import se.uu.ub.cora.json.builder.JsonBuilderFactory;
import se.uu.ub.cora.json.builder.JsonObjectBuilder;
import se.uu.ub.cora.testutils.mcr.MethodCallRecorder;

public class JsonBuilderFactorySpy implements JsonBuilderFactory {

	MethodCallRecorder MCR = new MethodCallRecorder();

	@Override
	public JsonArrayBuilder createArrayBuilder() {
		JsonArrayBuilderSpy out = new JsonArrayBuilderSpy();
		MCR.addCall();
		MCR.addReturned(out);
		return out;
	}

	@Override
	public JsonObjectBuilder createObjectBuilder() {
		MCR.addCall();
		JsonObjectBuilderSpy jsonObjectBuilderSpy = new JsonObjectBuilderSpy();
		MCR.addReturned(jsonObjectBuilderSpy);
		return jsonObjectBuilderSpy;
	}

}
