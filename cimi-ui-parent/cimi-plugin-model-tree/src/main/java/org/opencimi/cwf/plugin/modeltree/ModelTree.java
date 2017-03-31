/*
 * #%L
 * cwf-ui-patientheader
 * %%
 * Copyright (C) 2014 - 2016 Healthcare Services Platform Consortium
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.opencimi.cwf.plugin.modeltree;

import org.carewebframework.shell.plugins.PluginController;

/**
 * Controller for patient header plugin.
 */
public class ModelTree extends PluginController {
    
//    private static final Log log = LogFactory.getLog(PatientHeader.class);
//
//    @WiredComponent
//    private Toolbar tbPatient;
//
//    @WiredComponent
//    private Button btnDetail;
//
//    @WiredComponent(value = "popDetail.pnlDetail")
//    private BaseUIComponent pnlDetail;
//
//    @WiredComponent
//    private Label lblName;
//
//    @WiredComponent
//    private Label lblGender;
//
//    @WiredComponent
//    private Label lblDOBLabel;
//
//    @WiredComponent
//    private Label lblDOB;
//
//    @WiredComponent
//    private Label lblDODLabel;
//
//    @WiredComponent
//    private Label lblDOD;
//
//    @WiredComponent
//    private Label lblUser;
//
//    private String noSelection;
//
//    private Patient patient;
//
//    private String patientName;
//
//    private boolean needsDetail = true;
//
//    @Override
//    public void afterInitialized(BaseComponent comp) {
//        super.afterInitialized(comp);
//        noSelection = lblName.getLabel();
//        IUser user = SecurityUtil.getAuthenticatedUser();
//
//        if (user == null) {
//            setLabel(lblUser, "Unknown User", null);
//        } else {
//            setLabel(lblUser, user.getFullName() + " @ " + user.getSecurityDomain().getName(), null);
//        }
//        committed();
//    }
//
//    @EventHandler(value = "click", target = "lnkSelect")
//    private void onClick$lnkSelect() {
//        PatientSelection.show(true);
//    }
//
//    @EventHandler(value = "click", target = "@btnDetail")
//    private void onClick$btnDetail() {
//        buildDetail();
//    }
//
//    @Override
//    public void canceled() {
//    }
//
//    @Override
//    public void committed() {
//        hideLabels();
//        patient = PatientContext.getActivePatient();
//        needsDetail = true;
//        pnlDetail.destroyChildren();
//
//        if (log.isDebugEnabled()) {
//            log.debug("patient: " + patient);
//        }
//
//        if (patient == null) {
//            lblName.setLabel(noSelection);
//            btnDetail.setDisabled(true);
//            return;
//        }
//
//        btnDetail.setDisabled(false);
//        patientName = FhirUtil.formatName(patient.getName());
//        String mrn = FhirUtil.getMRNString(patient);
//        lblName.setLabel(patientName + (mrn.isEmpty() ? "" : "  (" + mrn + ")"));
//        setLabel(lblDOB, formatDateAndAge(patient.getBirthDate()), lblDOBLabel);
//        setLabel(lblDOD, formatDOD(patient.getDeceased()), lblDODLabel);
//        setLabel(lblGender, patient.hasGender() ? patient.getGender().getDisplay() : null, null);
//    }
//
//    @Override
//    public void pending(ISurveyResponse response) {
//        response.accept();
//    }
//
//    private String formatDOD(Type value) {
//        if (value == null) {
//            return null;
//        }
//
//        DateType dod = FhirUtil.getTyped(value, DateType.class);
//
//        if (dod != null) {
//            return formatDateAndAge(dod.getValue());
//        }
//
//        BooleanType isDead = FhirUtil.getTyped(value, BooleanType.class);
//
//        if (isDead != null && isDead.getValue()) {
//            return "unknown";
//        }
//
//        return null;
//    }
//
//    private String formatDateAndAge(Date date) {
//        return date == null ? null : DateUtil.formatDate(date) + " (" + DateUtil.formatAge(date) + ")";
//    }
//
//    private void setLabel(Label label, String value, BaseUIComponent associatedComponent) {
//        label.setLabel(value);
//        label.setVisible(value != null && !value.isEmpty());
//
//        if (associatedComponent != null) {
//            associatedComponent.setVisible(label.isVisible());
//        }
//    }
//
//    private void hideLabels() {
//        for (Label child : tbPatient.getChildren(Label.class)) {
//            if (child != lblName) {
//                child.setVisible(false);
//            }
//        }
//    }
//
//    private boolean buildDetail() {
//        if (!needsDetail) {
//            return false;
//        }
//
//        needsDetail = false;
//        boolean needsHeader;
//
//        // Names
//
//        needsHeader = true;
//
//        for (HumanName name : patient.getName()) {
//
//            String nm = FhirUtil.formatName(name);
//
//            if (patientName.equals(nm)) {
//                continue;
//            }
//
//            if (needsHeader) {
//                needsHeader = false;
//                addHeader("Other Names");
//            }
//
//            addDetail(nm, null);
//        }
//
//        // Identifiers
//
//        needsHeader = true;
//
//        for (Identifier id : patient.getIdentifier()) {
//            if (needsHeader) {
//                needsHeader = false;
//                addHeader("Identifiers");
//            }
//
//            String use = id.hasUse() ? id.getUse().getDisplay() : "";
//            String system = id.hasSystem() ? id.getSystem() : "";
//            String value = id.hasValue() ? id.getValue() : "";
//
//            if (!StringUtils.isEmpty(system)) {
//                value += " (" + system + ")";
//            }
//
//            addDetail(value, use);
//        }
//
//        // Communication
//
//        needsHeader = true;
//
//        for (PatientCommunicationComponent comm : patient.getCommunication()) {
//            if (needsHeader) {
//                needsHeader = false;
//                addHeader("Communication");
//            }
//
//            String language = FhirUtil.getDisplayValueForType(comm.getLanguage());
//
//            if (comm.getPreferred()) {
//                language += " (preferred)";
//            }
//
//            addDetail(language, null);
//        }
//        // Telecom info
//
//        needsHeader = true;
//
//        List<ContactPoint> telecoms = new ArrayList<>(patient.getTelecom());
//        Collections.sort(telecoms, new Comparator<ContactPoint>() {
//
//            @Override
//            public int compare(ContactPoint cp1, ContactPoint cp2) {
//                return cp1.getRank() - cp2.getRank();
//            }
//
//        });
//
//        for (ContactPoint telecom : telecoms) {
//            if (needsHeader) {
//                needsHeader = false;
//                addHeader("Contact Details");
//            }
//
//            String type = telecom.hasSystem() ? telecom.getSystem().getDisplay() : "";
//            String use = telecom.hasUse() ? telecom.getUse().getDisplay() : "";
//
//            if (!StringUtils.isEmpty(use)) {
//                type += " (" + use + ")";
//            }
//
//            addDetail(telecom.getValue(), type);
//        }
//
//        // Address(es)
//        needsHeader = true;
//
//        for (Address address : patient.getAddress()) {
//            if (needsHeader) {
//                needsHeader = false;
//                addHeader("Addresses");
//            }
//
//            String type = address.hasType() ? address.getType().getDisplay() : "";
//            String use = address.hasUse() ? address.getUse().getDisplay() : "";
//
//            if (!StringUtils.isEmpty(type)) {
//                use += " (" + type + ")";
//            }
//
//            addDetail(" ", use);
//
//            for (StringType line : address.getLine()) {
//                addDetail(line.getValue(), null);
//            }
//
//            StringBuilder line = new StringBuilder();
//            line.append(address.getCity()).append(", ");
//            line.append(address.getState()).append("  ");
//            line.append(address.getPostalCode());
//            addDetail(line.toString(), null);
//        }
//
//        if (pnlDetail.getFirstChild() == null) {
//            addDetail(StrUtil.getLabel("cwfpatientheader.nodetail.label"), null);
//        }
//
//        return true;
//    }
//
//    private void addHeader(String text) {
//        Label header = new Label(text);
//        header.addClass("cwf-patientheader-header");
//        pnlDetail.addChild(header);
//    }
//
//    private void addDetail(String text, String label) {
//        if (StringUtils.isEmpty(text)) {
//            return;
//        }
//
//        Div div = new Div();
//        pnlDetail.addChild(div);
//
//        if (label != null) {
//            Label lbl = new Label(label);
//            lbl.addClass("cwf-patientheader-label");
//            div.addChild(lbl);
//        }
//
//        div.addChild(new Label(text));
//    }
}
