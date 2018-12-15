package com.tree.boot.action.javaconfig;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//@Configuration
public class AutoConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }

    /**
     * 注入bean， 参数注入
     * @param compactDisk
     * @return
     */
    @Bean
    public CDPlayer cdPlayer(CompactDisk compactDisk){
        return new CDPlayer(compactDisk);
    }

    /**
     * 注入bean， 方法注入
     * @return
     */
    @Bean
    public CDPlayer cdPlayer2(){
        return new CDPlayer(compactDisk());
    }

    /**
     * 简单 bean
     * @return
     */
    @Bean
    public CompactDisk compactDisk(){
        return new CompactDisk();
    }

    class CDPlayer{
        private CompactDisk cd;

        public CDPlayer(CompactDisk compactDisk){
            this.cd = compactDisk;
        }

        public void play(){
            cd.play();
        }
    }

    class CompactDisk{
        public void play(){
            System.out.println("cd music");
        }
    }

    class MagicBean{

    }


    private class MagicExistsCondition implements Condition {
        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            Environment env = conditionContext.getEnvironment();
            return env.containsProperty("magic");
        }
    }
}
