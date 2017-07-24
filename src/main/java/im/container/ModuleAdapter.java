package im.container;

import im.Server;

/**
 * Created by tianxing on 16/12/1.
 *
 */
public class ModuleAdapter implements Module {


    private String name;



    public ModuleAdapter(String moduleName){
        if (moduleName == null){
            this.name = "未命名模块";
        }else {
            this.name = moduleName;
        }
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void initialize(Server server) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }
}
