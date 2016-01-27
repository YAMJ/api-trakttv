/*
 *      Copyright (c) 2015-2016 YAMJ Members
 *      https://github.com/orgs/YAMJ/people
 *
 *      This file is part of the TraktTV API.
 *
 *      The API is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The API is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the API.  If not, see <http://www.gnu.org/licenses/>.
 *
 *      Web: https://github.com/YAMJ/api-trakttv
 */
package org.yamj.api.trakttv.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;

@JsonRootName("crew")
public class Crew extends AbstractJsonMapping {

    private static final long serialVersionUID = -5757353819876172484L;

    @JsonProperty("directing")
    private List<CreditMember> directing;
    @JsonProperty("production")
    private List<CreditMember> production;
    @JsonProperty("writing")
    private List<CreditMember> writing;
    @JsonProperty("editing")
    private List<CreditMember> editing;
    @JsonProperty("camera")
    private List<CreditMember> camera;
    @JsonProperty("sound")
    private List<CreditMember> sound;
    @JsonProperty("art")
    private List<CreditMember> art;
    @JsonProperty("costume & make-up")
    private List<CreditMember> costumeAndMakeUp;
    @JsonProperty("visual effects")
    private List<CreditMember> visualEffects;
    @JsonProperty("crew")
    private List<CreditMember> other;

    public List<CreditMember> getDirecting() {
        return directing;
    }

    public void setDirecting(List<CreditMember> directing) {
        this.directing = directing;
    }

    public List<CreditMember> getProduction() {
        return production;
    }

    public void setProduction(List<CreditMember> production) {
        this.production = production;
    }

    public List<CreditMember> getWriting() {
        return writing;
    }

    public void setWriting(List<CreditMember> writing) {
        this.writing = writing;
    }

    public List<CreditMember> getEditing() {
        return editing;
    }

    public void setEditing(List<CreditMember> editing) {
        this.editing = editing;
    }

    public List<CreditMember> getCamera() {
        return camera;
    }

    public void setCamera(List<CreditMember> camera) {
        this.camera = camera;
    }

    public List<CreditMember> getSound() {
        return sound;
    }

    public void setSound(List<CreditMember> sound) {
        this.sound = sound;
    }

    public List<CreditMember> getArt() {
        return art;
    }

    public void setArt(List<CreditMember> art) {
        this.art = art;
    }

    public List<CreditMember> getCostumeAndMakeUp() {
        return costumeAndMakeUp;
    }

    public void setCostumeAndMakeUp(List<CreditMember> costumeAndMakeUp) {
        this.costumeAndMakeUp = costumeAndMakeUp;
    }

    public List<CreditMember> getVisualEffects() {
        return visualEffects;
    }

    public void setVisualEffects(List<CreditMember> visualEffects) {
        this.visualEffects = visualEffects;
    }

    public List<CreditMember> getOther() {
        return other;
    }

    public void setOther(List<CreditMember> other) {
        this.other = other;
    }
}
