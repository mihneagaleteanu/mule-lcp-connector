package com.points.lcp.internal;

import org.mule.runtime.api.meta.Category;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;


/**
 * This is the main class of an extension, is the entry point from which configurations, connection providers, operations
 * and sources are going to be declared.
 */
@Xml(prefix = "loyalty-commerce-platform")
@Extension(name = "Loyalty Commerce Platform", category = Category.CERTIFIED, vendor = "Points International")
@RequiresEnterpriseLicense(allowEvaluationLicense = true)
@Configurations(LoyaltyCommercePlatformConfiguration.class)
public class LoyaltyCommercePlatformExtension {

}
