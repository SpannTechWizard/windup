package org.jboss.windup.addon;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.forge.arquillian.AddonDependency;
import org.jboss.forge.arquillian.Dependencies;
import org.jboss.forge.arquillian.archive.ForgeArchive;
import org.jboss.forge.furnace.repositories.AddonDependencyEntry;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.runner.RunWith;


/**
 * This is here for reference.
 * Static getDeployment() doesn't allow leveraging subclassing. FORGE-1790
 * 
 * @author Ondrej Zizka, ozizka at redhat.com
 */
@RunWith(Arquillian.class)
public class AbstractTestCase
{

   @Deployment
   @Dependencies({
            //@AddonDependency(name = "org.jboss.windup.rules:rules"),
            @AddonDependency(name = "org.jboss.forge.furnace.container:cdi")
   })
   public static ForgeArchive getDeployment()
   {
      ForgeArchive archive = ShrinkWrap.create(ForgeArchive.class)
        .addBeansXML()
        .addAsAddonDependencies(
            //AddonDependencyEntry.create("org.jboss.windup.rules:rules"),
            AddonDependencyEntry.create("org.jboss.forge.furnace.container:cdi")
        );
      return archive;
   }

}