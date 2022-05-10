package com.fc.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.entity.UserExample;
import com.fc.service.UserService;

import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVo updata(User user) {
        int affect = userMapper.updateByPrimaryKeySelective(user);
        ResultVo resultVo;
        if (affect>0){
            //把修改后的user拿来
            User result = userMapper.selectByPrimaryKey(user.getId());
            resultVo=new ResultVo(200,"用户修改成功",true,result);
        }else {
            resultVo=new ResultVo(400,"用户修改失败",false,null);
        }
        return resultVo;

    }
    //del
    @Override
    public ResultVo del(Long id) {

        int affect = userMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo=new ResultVo(400,"删除失败",false,null);
        }
        return resultVo;
    }

    //add
    @Override
    public ResultVo add(User user) {
        //如果前端给我们创建时间我们就用他给的
        if (user.getCreateTime()==null){
            user.setCreateTime(new Date());
        }
        int affect = userMapper.insertSelective(user);


        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"添加成功",true,user);
        }else {
            resultVo=new ResultVo(400,"添加失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo login( String username, String password) {
        ResultVo resultVo=new ResultVo();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);

        if (users !=null&&users.size()>0){
            //用户名存在
            //如果存在
            User user = users.get(0);
            if (user.getPassword().equals(password)){
                //登陆成功
                resultVo.setSuccess(false);
                resultVo.setMessage("登录成功");
                resultVo.setCode(66);
                //登录成功创建token

                //准备头部
                HashMap<String, Object> header = new HashMap<>();
                //算法
                header.put("alg","HS256");
                //类型
                header.put("type","JWT");

                //盐值 不能写死 要是一个动态的值或者是一个随机数
                //盐值可以存在从数据库中（性能低）
                //盐值还可以存在缓存中（Redis）

                //目前只能存在载荷中（不安全）
                //获取盐值随机数
                String salt = String.valueOf((int) ((Math.random() * 9 + 1) * 1000000));

                //获取token
               String token= JWT.create()
                        //头部
                        .withHeader(header)
                        //过期时间
                       //目前先写死 尽可能短
                       //但是现在先写死 因为会涉及token续签的问题
                        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 120))
                        //签发人
                        . withIssuer("admin")
                        //发布时间
                        .withIssuedAt(new Date())
                        //主题
                        .withSubject("权限认证")
                        //载荷
                        .withClaim("id",user.getId())
                        .withClaim("salt",salt)

//                        .withClaim("role",user.getRole)
                        .withClaim("username",user.getUsername())
                        //签发   盐值
                        .sign(Algorithm.HMAC256(salt));

                HashMap<String, Object> data = new HashMap<>();
                user.setPassword(null);
                data.put("user",user);
                data.put("token",token);
                resultVo.setData(data);


            }else {
                //登陆失败

                resultVo.setData(null);
               resultVo.setSuccess(false);
                resultVo.setMessage("登录失败，当前密码不对");
                resultVo.setCode(-2);
            }

        }else {
            //用户名不存在
            // 用户名不存在
            resultVo.setData(null);
           resultVo.setSuccess(false);
            resultVo.setMessage("登录失败，当前用户名不存在");
            resultVo.setCode(-1);
        }
return resultVo;
//        User user = userMapper.login(username);
//        ResultVo resultVo;
//        if (username!=null){
//            if (username.equals(user.getUsername())&&password.equals(user.getPassword())){
//                Map<String,Object>claim=new HashMap<>();
//
//                //创建token
//                String token = JwtUtil.createToken(claim, System.currentTimeMillis() * 1000 * 60);
//
//                resultVo = new ResultVo(200, "登录成功", true,token );
//            }else {
//                resultVo = new ResultVo(400, "登录失败", false,"" );
//            }
//        }else {
//            resultVo = new ResultVo(400, "登录失败", false,"" );
//        }
//        System.out.println(user);
//        return resultVo;


    }

    //list
    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, User param) {
        List<User> users;

        ResultVo resultVO;

        try {
            if (param.getId() == null) {
                PageHelper.startPage(pageNum, pageSize);

                UserExample userExample = new UserExample();
                if (param.getName()!=null){
                    UserExample.Criteria criteria = userExample.createCriteria();
                    criteria.andNameLike("%"+param.getName()+"%");
                }
                if (param.getUsername()!=null){
                    UserExample.Criteria criteria = userExample.createCriteria();
                    criteria.andUsernameLike("%"+param.getUsername()+"%");
                }
                if (param.getGender()!=null){
                    UserExample.Criteria criteria = userExample.createCriteria();
                    criteria.andGenderLike("%"+param.getGender()+"%");
                }
                users = userMapper.selectByExample(userExample);
            } else {
                User user = userMapper.selectByPrimaryKey(param.getId());
                users = new ArrayList<>();
                users.add(user);
            }

            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVo<User> dataVO = new DataVo<>(pageInfo.getTotal(), users, pageNum, pageSize);

            resultVO = new ResultVo(200, "查询成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVo(400, "查询失败", false, null);
        }

        return resultVO;
    }
}
