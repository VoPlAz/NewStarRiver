package net.newstarriver;

import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.event.*;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.message.data.*;
import org.jetbrains.annotations.NotNull;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ModuleManager extends SimpleListenerHost {

@EventHandler

    private ListeningStatus onEvent(GroupMessageEvent GroupEvent){
    String Message = GroupEvent.getMessage().contentToString();

    switch (Message) {
        case "菜单":
            GroupEvent.getSubject().sendMessage("            \uD83C\uDF88菜单\uD83C\uDF88            \n⚡娱乐菜单 关于作者⚡\n⚡运行状态 基础命令⚡\n ⚡—————————————⚡\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
            break;
        case "娱乐菜单":
            GroupEvent.getSubject().sendMessage("          \uD83C\uDF88娱乐菜单\uD83C\uDF88          \n⚡随机动漫 每天热点⚡\n⚡生成二维码 我要开纪⚡\n⚡—————————————⚡\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
            break;
        case "关于作者":
            GroupEvent.getSubject().sendMessage("⚡作者:WindStream\n⚡QQ:1514037660\n⚡GitHub:github.com/VoPlAz\n⚡WebSite:windstream.liangzai45.com\n⚡Organize:StreamLgiht\n⚡机器人框架:Mirai\n⚡开发语言:Java(Mirai官方原生JavaSDK)\n⚡----------------------------⚡\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
            break;
        case "随机动漫":
            try {
                Image image = Contact.uploadImage(GroupEvent.getSubject(), new URL("https://www.dmoe.cc/random.php").openConnection().getInputStream());
                GroupEvent.getSubject().sendMessage(image);
                break;
            } catch (IOException e) {
                GroupEvent.getSubject().sendMessage("请求出错...");
                throw new RuntimeException(e);
            }
        case "运行状态":
            String java_Version = System.getProperty("java.version");
            String Os_Name = System.getProperty("os.name");
            String Os_Arch = System.getProperty("os.arch");
            long StarRiver_endTime = System.currentTimeMillis();
            long usedTime_s = (StarRiver_endTime - StarRiver.StarRiver_startTime) / 1000;
            long usedTime_m = 0;
            long usedTime_h = 0;
            long usedTime_d = 0;
            String usedTime;
            while (true) {
                if (usedTime_s >= 60) {
                    usedTime_s -= 60;
                    usedTime_m += 1;
                } else if (usedTime_m >= 60) {
                    usedTime_m -= 60;
                    usedTime_h += 1;
                } else if (usedTime_h >= 24) {
                    usedTime_h -= 24;
                    usedTime_d += 1;
                } else if (usedTime_s <= 60) {
                    usedTime = usedTime_d + "天" + usedTime_h + "小时" + usedTime_m + "分钟" + usedTime_s + "秒";
                    break;
                }
            }
            GroupEvent.getSubject().sendMessage("⚡运行中...\n⚡插件名:StarRiver\n⚡插件版本:1.0.0\n⚡Java版本:" + java_Version + "\n⚡系统:" + Os_Name + "\n⚡系统架构:" + Os_Arch + "\n⚡运行时长:" + usedTime + "\n⚡—————————————⚡\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
            break;
        case "每天热点":
            try {
                Image image = Contact.uploadImage(GroupEvent.getSubject(), new URL("https://api.qqsuu.cn/api/60s").openConnection().getInputStream());
                GroupEvent.getSubject().sendMessage(image);
                break;
            } catch (IOException e) {
                GroupEvent.getSubject().sendMessage("请求出错...");
                throw new RuntimeException(e);
            }
        case "生成二维码":
            GroupEvent.getSubject().sendMessage("输入:二维码 [内容]");
            break;
        case "基础命令":
            GroupEvent.getSubject().sendMessage("            \uD83C\uDF88主人命令\uD83C\uDF88            \n⚡智能清屏 敬请期待⚡\n⚡—————————————⚡\n\uD83C\uDF89StarRiver群管系统\uD83C\uDF89");
        case "智能清屏":
            GroupEvent.getSubject().sendMessage("输入:清屏 [行数]");
        case "我要开纪":
            try {
                Image image = Contact.uploadImage(GroupEvent.getSubject(), new URL("http://windstream.liangzai45.com/wgworld/wgworld.jpg").openConnection().getInputStream());
                GroupEvent.getSubject().sendMessage(new PlainText("\uD83C\uDF89在神奇的外纪世界，有着无尽的斑斓，有着众多服务器等你殴打，有五花八门的作弊端等你发现，同时，也布满了危险，有着网骗神的圈钱大法，有恶俗狗的扣字攻击，有NoIQ者的胡言乱语。在外纪世界，你同样可以构建你自己的客户端，吃属于你的那份蛋糕，还在犹豫什么，赶紧发送[纪狗注册 +Id]来开始吧!!\uD83C\uDF89").plus(image));
            } catch (IOException e) {
                GroupEvent.getSubject().sendMessage("出错了，请联系相关人员报错!");
                throw new RuntimeException(e);
            }
        default:
            if (Message.substring(0, 3).equals("二维码") && Message.substring(3, 4).equals(" ")) {
                String erweiText = Message.substring(4);
                try {
                    Image image = Contact.uploadImage(GroupEvent.getSubject(), new URL("https://api.qqsuu.cn/api/qrcode?text=" + erweiText + "&size=128").openConnection().getInputStream());
                    GroupEvent.getSubject().sendMessage(image);
                } catch (IOException e) {
                    GroupEvent.getSubject().sendMessage("请求出错");
                    throw new RuntimeException(e);
                }
            } else if (Message.substring(0, 3).equals("二维码") && (Message.substring(3, 4).equals(" ") == false) == true) {
                MessageChain chain = new MessageChainBuilder()
                        .append(new QuoteReply(GroupEvent.getMessage()))
                        .append(new At(GroupEvent.getSender().getId()))
                        .append("StarRiver:操作有误，请检查命令格式.")
                        .build();
                GroupEvent.getSubject().sendMessage(chain);
            } else if (Message.substring(0, 2).equals("清屏") && Message.substring(2, 3).equals(" ")) {
                if (GroupEvent.getSender().getId() == 1514037660) {
                    try {
                        int qingp_hangshu = Integer.parseInt(Message.substring(3));
                        int while_key = 0;
                        String qingp_text = "";
                        while (true) {
                            if (while_key == qingp_hangshu) {
                                break;
                            }
                            qingp_text += "\n";
                            while_key += 1;
                        }
                        GroupEvent.getSubject().sendMessage(qingp_text);
                    } catch (NumberFormatException e) {
                        GroupEvent.getSubject().sendMessage("StarRiver:操作错误[" + Message + "]:请检查参数是否有误");
                    }
                } else {
                    MessageChain chain = new MessageChainBuilder()
                            .append(new At(GroupEvent.getSender().getId()))
                            .append("StarRiver:您无权操作该命令.")
                            .build();
                    GroupEvent.getSubject().sendMessage(chain);
                }
            } else if (Message.substring(0, 2).equals("清屏") && (Message.substring(2, 3).equals(" ") == false) == true) {
                MessageChain chain = new MessageChainBuilder()
                        .append(new QuoteReply(GroupEvent.getMessage()))
                        .append(new At(GroupEvent.getSender().getId()))
                        .append("StarRiver:操作有误，请检查命令格式.")
                        .build();
                GroupEvent.getSubject().sendMessage(chain);
            } else if (Message.substring(0,4).equals("我要开纪") && Message.substring(4,5).equals(" ")) {
                GroupEvent.getSubject().sendMessage("暂未开放.");
            }
    }
    return ListeningStatus.LISTENING;
}}



















