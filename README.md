# JsonDataCache
Android数据缓存工具

###保存数据
jsonHelper.saveJson(String content, String path, String filename,int saveTag);

content:要保存的数据

path：保存路径 /data/data/a

filename：保存的文件名字 /abc.txt

saveTag:标记，用于在回调函数中区分多个保存事务


保存数据回调函数
```Java
 @Override
    public void finishSave(int saveTag, boolean success) {
        switch (saveTag){
            case 0:
                if (success){
                    Log.i("Save"+saveTag,"成功");
                }else {
                    Log.i("Save"+saveTag,"失败");
                }
                break;
            case 1:
                if (success){
                    Log.i("Save"+saveTag,"成功");
                }else {
                    Log.i("Save"+saveTag,"失败");
                }
                break;
        }
    }
```
###读取数据
jsonHelper.loadJson( String path, String filename,int loadTag);

各参数意义可参照保存数据中

读取数据回调函数
```Java
@Override
    public void finishLoad(int loadTag, LoadBean loadBean) {
        switch (loadTag){
            case 0:
                if(loadBean.isSuccess()){
                    Log.i("Load"+loadTag,loadBean.getResult());
                }else{
                    Log.i("Load"+loadTag,"失败");
                }
                break;
            case 1:
                if(loadBean.isSuccess()){
                    Log.i("Load"+loadTag,loadBean.getResult());
                }else{
                    Log.i("Load"+loadTag,"失败");
                }

                break;
        }
    }
```

###删除某一个缓存文件
 jsonHelper.clearCache(String path,String fileName, int deleteTag);
 
 参数意义相同
 
 删除某一个缓存文件的回调函数
 ```Java
    @Override
    public void finishDelete(int deleteTag, boolean success) {
        switch (deleteTag){
            case 0:
                if (success){
                    Log.i("Delete"+deleteTag,"完成");
                }else {
                    Log.i("Delete"+deleteTag,"失败");
                }
                break;
            case 1:
                if (success){
                    Log.i("Delete"+deleteTag,"完成");
                }else {
                    Log.i("Delete"+deleteTag,"失败");
                }
                break;
        }
    }
 ```
 
 ###删除全部缓存文件
 
 jsonHelper.clearAllCache(String path, int deleteAllTag);
 
 参数意义相同
 
 删除全部缓存文件的回调函数
 
 ```Java
     @Override
    public void finishDeleteAll(int deleteTag) {
        switch (deleteTag){
            case 0:
                Log.i("Delete_ALL"+deleteTag,"完成");
                break;
        }
    }
 ```
